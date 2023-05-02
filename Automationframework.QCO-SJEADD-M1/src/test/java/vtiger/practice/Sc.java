package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sc {
		
		public static void main(String[] args) throws IOException {
		
			//Generate Random Number
			Random ran = new Random();
			int random = ran.nextInt(1000);
			
			//Read all the required Data
			FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pObj = new Properties();
			pObj.load(fisp);
			String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");
			
			FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fise);
			String ORGNAME = wb.getSheet("Organisation").getRow(1).getCell(2).getStringCellValue()+random;
			
			WebDriver driver = null;
			
			//Step 1: launch the browser - RUNTIME POLYMORPHISM 
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(); // driver is initialised to chrome 
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(); // driver is initialised to chrome
			}
			else
			{
				System.out.println("invalid browser name");
			}
			
			 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);
			
			//Step 2: Login to App
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//Step 3: Navigate to Organizations LInk
			driver.findElement(By.linkText("Organizations")).click();
			
			//Step 4: click on Create Organization Look Up Image
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			//Step 5: Create Organization with Mnadatory fields
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			
			//Step 6: Save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//Step 7: Validate
			String OrgHeader = driver.findElement(By.className("dvHeaderText")).getText();
			if(OrgHeader.contains(ORGNAME))
			{
				System.out.println("=== PASS ===");
			}
			else
			{
				System.out.println("=== FAIL ===");
			}
			
			//Step 8: Logout
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("Signout successfull");	
		}

	}





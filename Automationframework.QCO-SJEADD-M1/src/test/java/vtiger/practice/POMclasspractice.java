package vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.Genericutilites.ExcelsheetDataFileUtility;
import vTiger.Genericutilites.JavaUtility;
import vTiger.Genericutilites.PropertyFileUtility;
import vTiger.Genericutilites.WebDriverutility;
import vTiger.ObjectRepository.LoginPage;

public class POMclasspractice {
	public static void main(String[] args) throws IOException {
		
		JavaUtility jutil=new JavaUtility();
		WebDriverutility wutil=new WebDriverutility();
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelsheetDataFileUtility eutil=new ExcelsheetDataFileUtility();
		String browser=putil.readDatafromPropertyfile("browser");
		String url=putil.readDatafromPropertyfile("url");
		String username=putil.readDatafromPropertyfile("username");
		String password=putil.readDatafromPropertyfile("password");
		String Orgname=eutil.Readthedatafromexcelsheet("Organisation", 1, 2)+jutil.random();
		WebDriver driver=null;
		//Step 1: launch the browser - RUNTIME POLYMORPHISM 
				if(browser.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(); // driver is initialised to chrome 
				}
				else if(browser.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver(); // driver is initialised to chrome
				}
				else
				{
					System.out.println("invalid browser name");
				}
	
		wutil.maximize(driver);
		wutil.waitforpagetoload(driver);
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(username, password);
		//Step 3: Navigate to Organizations LInk
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 4: click on Create Organization Look Up Image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 5: Create Organization with Mnadatory fields
				driver.findElement(By.name("accountname")).sendKeys(Orgname);
				
				//Step 6: Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 7: Validate
				String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(OrgHeader.contains(Orgname))
				{
					System.out.println("=== PASS ===");
				}
				else
				{
					System.out.println("=== FAIL ===");
				}
				
				//Step 8: Logout
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wutil.movetoelement(driver, ele);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Signout successfull");
	}

}

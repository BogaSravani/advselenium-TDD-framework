package vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.Genericutilites.ExcelsheetDataFileUtility;
import vTiger.Genericutilites.JavaUtility;
import vTiger.Genericutilites.PropertyFileUtility;
import vTiger.Genericutilites.WebDriverutility;

public class Demo4 {
	public static void main(String[] args) throws IOException {
		/* Create Organization */

		// Create Object of all Utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelsheetDataFileUtility eUtil = new ExcelsheetDataFileUtility();
		WebDriverutility wUtil = new WebDriverutility();

		// Read all the required Data
		String BROWSER = pUtil.readDatafromPropertyfile("browser");
		String URL = pUtil.readDatafromPropertyfile("url");
		String USERNAME = pUtil.readDatafromPropertyfile("username");
		String PASSWORD = pUtil.readDatafromPropertyfile("password");

		String LASTNAME = eUtil.Readthedatafromexcelsheet("Contact", 4, 2);
		String ORGNAME = eUtil.Readthedatafromexcelsheet("Contact", 4, 3) + jUtil.random();

		WebDriver driver = null;

		// Step 1: launch the browser - RUNTIME POLYMORPHISM
		if (BROWSER.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); // driver is initialised to chrome
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); // driver is initialised to chrome
		} else {
			System.out.println("invalid browser name");
		}

		wUtil.maximize(driver);
		wUtil.waitforpagetoload(driver);
		driver.get(URL);

		// Step 2: Login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 3: Navigate to Organizations LInk
		driver.findElement(By.linkText("Organizations")).click();

		// Step 4: click on Create Organization Look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Step 5: Create Organization with Mnadatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 7: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println(OrgHeader + " --> Organization created successfully");
		} else {
			System.out.println("Organization creation failed");
		}

		/* Create Contact Using the same Organization */
		driver.findElement(By.linkText("Contacts")).click();

		// Step 9: Navigate create contact look up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 10: Create Contact
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 11: Click on Organization look up Image
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();

		// Step 12: switch the control to child page
		wUtil.windowhandle(driver, "Accounts");

		// Step 13: search for required Org
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();

		// Step 14: click on Org
		// driver.findElement(By.linkText(ORGNAME)).click();

		// Dynamic xpath - ORGNAME is a dynamic Data
		// a[.='wipro123']
		// a[.='infy']
		driver.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();

		// Step 15: switch the control back to parent
		wUtil.windowhandle(driver, "Contacts");
		wUtil.totakescreenshot(driver, "Contact");

		// Step 16: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 17: Validate
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println(ContactHeader + " -- PASS --");
		} else {
			System.out.println("-- FAIL --");
		}
		
		//Step 18 logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.movetoelement(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Signout successfull");

	}


	}



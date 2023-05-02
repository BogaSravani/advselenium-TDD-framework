package vTiger.Genericutilites;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * this class consist of all the basic configurations
 * @author boga sravani	
 */

public class Baseclass {
  public WebDriverutility wutil=new WebDriverutility();
  public JavaUtility jutil=new JavaUtility();
  public PropertyFileUtility putil=new PropertyFileUtility();
  public ExcelsheetDataFileUtility eutil=new ExcelsheetDataFileUtility();
  
  public WebDriver driver=null;
  public static WebDriver ldriver;
  @BeforeSuite(alwaysRun=true)
  public void bsconfig()
  {
	  System.out.println("----database connected----");
  }
//  @Parameters("browser")
   //  @BeforeTest
//  @BeforeClass
	@BeforeClass(groups={"smokesuite","regressionsuite"})
	public void bcconfig(/*String browser*/) throws IOException
	{
		String browser=putil.readDatafromPropertyfile("browser");
		String url=putil.readDatafromPropertyfile("url");
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			System.out.println("Browser launched successfully");
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			System.out.println("Browser launched successfully");
		}
		ldriver=driver;
		wutil.maximize(driver);
		wutil.waitforpagetoload(driver);
		driver.get(url);
	}
	@BeforeMethod(groups={"smokesuite","regressionsuite"})
	public void bmconfig() throws IOException
	{
		String username=putil.readDatafromPropertyfile("username");
		String password=putil.readDatafromPropertyfile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(username, password);
		System.out.println("login successfull");
	}
	@AfterMethod(groups={"smokesuite","regressionsuite"})
	public void amconfig()
	{
	HomePage hp=new HomePage(driver);
	hp.signout(driver);
	System.out.println("logout successfull");
	}
	//@AfterTest
	//@AfterClass
	@AfterClass(groups={"smokesuite","regressionsuite"})
	public void acconfig()
	{
		driver.quit();
		System.out.println("browser closed successfully");
	}
	@AfterSuite(groups={"smokesuite","regressionsuite"})
	public void asconfig()
	{
		System.out.println("database closed successfully");
	}
	
  

}

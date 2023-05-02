package vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.Genericutilites.ExcelsheetDataFileUtility;
import vTiger.Genericutilites.JavaUtility;
import vTiger.Genericutilites.PropertyFileUtility;
import vTiger.Genericutilites.WebDriverutility;
import vTiger.ObjectRepository.CreatenewContactPage;
import vTiger.ObjectRepository.CreatenewOrganisationPage;
import vTiger.ObjectRepository.DetailsorgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrgInfoNamePage;

public class Demo {
	public static void main(String[] args) throws IOException {
	WebDriverutility wutil=new WebDriverutility();
	PropertyFileUtility putil=new PropertyFileUtility();
	ExcelsheetDataFileUtility eutil=new ExcelsheetDataFileUtility();
	JavaUtility jutil=new JavaUtility();
	//String browser=putil.readDatafromPropertyfile("browser");
	//String url=putil.readDatafromPropertyfile("url");
	//String username=putil.readDatafromPropertyfile("username");
	//String password=putil.readDatafromPropertyfile("password");
	//String orgname=eutil.Readthedatafromexcelsheet("Organisation", 1, 2)+jutil.random();
	WebDriver driver=null;
	if(putil.readDatafromPropertyfile("browser").equalsIgnoreCase("Edge"))
	{
		driver=new EdgeDriver();
	}
	else if(putil.readDatafromPropertyfile("browser").equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	driver.get(putil.readDatafromPropertyfile("url"));
	wutil.maximize(driver);
	wutil.waitforpagetoload(driver);
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(putil.readDatafromPropertyfile("username"),putil.readDatafromPropertyfile("password"));
	HomePage hp=new HomePage(driver);
	hp.getorgbutton().click();
	CreatenewOrganisationPage op=new CreatenewOrganisationPage(driver);
	op.getneworg().click();
	DetailsorgPage cp=new  DetailsorgPage(driver);
	cp.getneworgname().sendKeys(eutil.Readthedatafromexcelsheet("Organisation",1, 2)+jutil.random());
	cp.getsave().click();
	OrgInfoNamePage op1=new OrgInfoNamePage(driver);
	String title=op1.getCorgname().getText();
	if(title.contains(eutil.Readthedatafromexcelsheet("Organisation", 1, 2)))
	{
		System.out.println("pass");
	}
	hp.signout(driver);
	wutil.movetoelement(driver,hp.getimgsignout());
	hp.getlogout().click();
	driver.close();
	System.out.println("logout succesfull");
	
	
	
}
}
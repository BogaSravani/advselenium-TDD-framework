package vtiger.practice;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import vTiger.Genericutilites.ExcelsheetDataFileUtility;
import vTiger.Genericutilites.JavaUtility;
import vTiger.Genericutilites.PropertyFileUtility;
import vTiger.Genericutilites.WebDriverutility;
import vTiger.ObjectRepository.ContinfoNamePage;
import vTiger.ObjectRepository.CreatenewContactPage;
import vTiger.ObjectRepository.DetailscontPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class Scenario1 {
	public static void main(String[] args) throws IOException {
		WebDriverutility wutil=new WebDriverutility();
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelsheetDataFileUtility eutil=new ExcelsheetDataFileUtility();
		JavaUtility jutil=new JavaUtility();
		String browser=putil.readDatafromPropertyfile("browser");
		String url=putil.readDatafromPropertyfile("url");
		String username=putil.readDatafromPropertyfile("username");
		String password=putil.readDatafromPropertyfile("password");
		String lastname=eutil.Readthedatafromexcelsheet("Contact",1,2)+jutil.random();
		
		WebDriver driver=null;
		if(browser.contains("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		driver.get(url);
		wutil.maximize(driver);
		wutil.waitforpagetoload(driver);
		
		//step1:login to the application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(username, password);
		//step2:click on contact button
		HomePage hp=new HomePage(driver);
		hp.clickoncontbutton();
		//step3:click on contact lookup icon
	 CreatenewContactPage cp1=new CreatenewContactPage(driver);
	 cp1.clickoncontlookupicon();
	 //step4:create contact with mandatory field
	 DetailscontPage dp1=new DetailscontPage(driver);
	 dp1.createcont(lastname);
	//step5:getting contact name for validation
	ContinfoNamePage cop=new ContinfoNamePage(driver);
	String contname=cop.getorgname();
	//validation
	if(contname.contains(lastname))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	//logout
	hp.signout(driver);
	System.out.println("logout successfull");
	driver.close();
	}

}

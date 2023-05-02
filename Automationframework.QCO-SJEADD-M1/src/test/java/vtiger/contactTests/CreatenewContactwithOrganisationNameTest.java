package vtiger.contactTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.Genericutilites.Baseclass;
import vTiger.Genericutilites.ExcelsheetDataFileUtility;
import vTiger.Genericutilites.JavaUtility;
import vTiger.Genericutilites.PropertyFileUtility;
import vTiger.Genericutilites.WebDriverutility;
import vTiger.ObjectRepository.ContinfoNamePage;
import vTiger.ObjectRepository.CreatenewContactPage;
import vTiger.ObjectRepository.CreatenewOrganisationPage;
import vTiger.ObjectRepository.DetailscontPage;
import vTiger.ObjectRepository.DetailsorgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrgInfoNamePage;
//@Listeners(vTiger.Genericutilites.ListenersImplementationClass.class)
public class CreatenewContactwithOrganisationNameTest extends Baseclass{
	@Test
	public void createContactWithOrgNameTest() throws IOException
	  {
		 
		String lastname=eutil.Readthedatafromexcelsheet("Contact", 4, 2);
		String orgname=eutil.Readthedatafromexcelsheet("Contact", 4, 3)+jutil.random();
		 
		//step3:naviagte to contacts
		HomePage hp=new HomePage(driver);
		hp.clickonorgbutton();
		//step4:click on create new contact button
		CreatenewOrganisationPage cp=new CreatenewOrganisationPage(driver);
		cp.click();
		//step5:fill All the mandatory fields
		 DetailsorgPage dp=new DetailsorgPage(driver);
		 dp.createneworg(orgname);
		 //step6:validate
		 OrgInfoNamePage op1=new OrgInfoNamePage(driver);
			String title=op1.takeorgname();
			Assert.assertTrue(title.contains(orgname));
		/*create contact using same orgname*/
			hp.clickoncontbutton();
			//step7:clicck on contact lookup icon
		 CreatenewContactPage cp1=new CreatenewContactPage(driver);
		 cp1.clickoncontlookupicon();
		 //step8:create contact with orgname
		 DetailscontPage dp1=new DetailscontPage(driver);
		 dp1.creatcont(driver, lastname, orgname);
		 //Assert.fail();
		//wutil.totakescreenshot(driver, "Contact");
		//step9:getting contact name for validation
		ContinfoNamePage cop=new ContinfoNamePage(driver);
		String contname=cop.getorgname();
		//validation
		 Assert.assertTrue(contname.contains(lastname));	 
		
		
		
		
	}

}

package vtiger.OrganisationsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.Genericutilites.Baseclass;
import vTiger.Genericutilites.ExcelsheetDataFileUtility;
import vTiger.Genericutilites.JavaUtility;
import vTiger.Genericutilites.PropertyFileUtility;
import vTiger.Genericutilites.WebDriverutility;
import vTiger.ObjectRepository.CreatenewOrganisationPage;
import vTiger.ObjectRepository.DetailsorgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrgInfoNamePage;

public class CreatenewOrganisationwithindustrydropdownTest extends Baseclass {
	@Test
	public void createNewOrgWithIndustryTest() throws IOException
           {
			 
			String orgname=eutil.Readthedatafromexcelsheet("Organisation",4,2)+jutil.random();
			String industry=eutil.Readthedatafromexcelsheet("Organisation",4,3);
			
	//step2:navigate to organisation link
		HomePage hp=new HomePage(driver);
		hp.clickonorgbutton();
	//step3:click on create new organisation lookup icon
		CreatenewOrganisationPage cp=new CreatenewOrganisationPage(driver);
		cp.click();
	//step4:fill all mandatory fields and select chemicals from industry dropdown and  save
		DetailsorgPage dp=new DetailsorgPage(driver);
		dp.createneworg(orgname,industry);
		//step5:get orginfo name
	OrgInfoNamePage op=new  OrgInfoNamePage(driver);
	String title=op.takeorgname();
	 Assert.assertTrue(title.contains(orgname));
	
	 
		}
}

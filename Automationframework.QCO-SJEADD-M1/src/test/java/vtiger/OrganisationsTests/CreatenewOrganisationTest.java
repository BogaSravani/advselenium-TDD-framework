package vtiger.OrganisationsTests;

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
import vTiger.ObjectRepository.CreatenewOrganisationPage;
import vTiger.ObjectRepository.DetailsorgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrgInfoNamePage;
@Listeners(vTiger.Genericutilites.ListenersImplementationClass.class)
public class CreatenewOrganisationTest extends Baseclass{
	@Test(groups={"smokesuite","regressionsuite"})
	public void createNewOrgTest() throws IOException
  {
	 
	String orgname=eutil.Readthedatafromexcelsheet("Organisation", 1, 2)+jutil.random();
	 
	//step3:navigate to organisation link
	HomePage hp=new HomePage(driver);
	hp.clickonorgbutton();
	//step4:click on create new organisation button
	CreatenewOrganisationPage op=new CreatenewOrganisationPage(driver);
	op.click();
	//Assert.fail();
	//step5:enter mandatory fields into organisation details page
	DetailsorgPage cp=new  DetailsorgPage(driver);
	 cp.createneworg(orgname);
	//step6:getting created org name
	OrgInfoNamePage op1=new OrgInfoNamePage(driver);
	String title=op1.takeorgname();
	//step7:validation
	 Assert.assertTrue(title.contains(orgname));
}
	@Test(groups="regressionsuite")
	public void demo()
	{
		System.out.println("it is demo");
	}
}

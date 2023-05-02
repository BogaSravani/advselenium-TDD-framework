package vtiger.OrganisationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

public class CreateMultipleOrgTest extends Baseclass {
	 
@Test(dataProvider="multipleorg")
public void getmultipleorg(String org,String industry) throws IOException
{
	 
	
	String orgname=org+jutil.random();
	 
	//step3:navigate to organisation link
	HomePage hp=new HomePage(driver);
	hp.clickonorgbutton();
	//step4:click on create new organisation button
	CreatenewOrganisationPage op=new CreatenewOrganisationPage(driver);
	op.click();
	//step5:enter mandatory fields into organisation details page
	DetailsorgPage cp=new  DetailsorgPage(driver);
	 cp.createneworg(orgname,industry);
	//step6:getting created org name
	OrgInfoNamePage op1=new OrgInfoNamePage(driver);
	String title=op1.takeorgname();
	//step7:validation
	 Assert.assertTrue(title.contains(orgname));
	 
	 
}


@DataProvider(name="multipleorg")
public Object[][] getdata() throws EncryptedDocumentException, IOException
{
	return eutil.readMultipledatafromexcelsheet("DataProviderOrg");
}
}

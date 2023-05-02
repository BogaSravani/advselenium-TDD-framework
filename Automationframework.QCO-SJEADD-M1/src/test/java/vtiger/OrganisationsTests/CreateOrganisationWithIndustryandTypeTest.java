package vtiger.OrganisationsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.Genericutilites.Baseclass;
import vTiger.ObjectRepository.CreatenewOrganisationPage;
import vTiger.ObjectRepository.DetailsorgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrgInfoNamePage;

public class CreateOrganisationWithIndustryandTypeTest extends Baseclass{
	@Test
	public void createOrgWithIndustryandType() throws IOException
	{
		 //step1: get organisation name ,industry and type
		String orgname=eutil.Readthedatafromexcelsheet("Organisation", 7, 2)+jutil.random();
		String Industry=eutil.Readthedatafromexcelsheet("Organisation", 7, 3);
		String Type=eutil.Readthedatafromexcelsheet("Organisation", 7, 4);
		//step2:navigate to organisation link
		HomePage hp=new HomePage(driver);
		hp.clickonorgbutton();
		//step3:click on create new organisation button
		CreatenewOrganisationPage cp=new CreatenewOrganisationPage(driver);
		cp.click();
		//Assert.fail();
		 //step4:fill all the mandatory fields along with industry
		DetailsorgPage dp=new DetailsorgPage(driver);
		dp.createneworg(orgname,Type,Industry);
		//step5:validate
		OrgInfoNamePage op=new OrgInfoNamePage(driver);
		String name=op.takeorgname();
		Assert.assertTrue(name.contains(orgname));	 	 
	}
}
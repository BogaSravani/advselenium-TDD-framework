package vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import vTiger.Genericutilites.Baseclass;
import vTiger.Genericutilites.ExcelsheetDataFileUtility;
import vTiger.ObjectRepository.CreatenewOrganisationPage;
import vTiger.ObjectRepository.DetailsorgPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrgInfoNamePage;

public class Practice extends Baseclass {
	 
	ExcelsheetDataFileUtility eutil=new ExcelsheetDataFileUtility();
	//@Test
	public void createorg() throws EncryptedDocumentException, IOException
	{
		String orgname=eutil.Readthedatafromexcelsheet("Organisation", 1, 2)+jutil.random();
		
		HomePage hp=new HomePage(driver);
		hp.clickonorgbutton();
		
		CreatenewOrganisationPage cp=new CreatenewOrganisationPage(driver);
		cp.click();
		DetailsorgPage dp=new DetailsorgPage(driver);
		dp.createneworg(orgname);
		OrgInfoNamePage op=new OrgInfoNamePage(driver);
		String name=op.takeorgname();
		if(name.contains(orgname))
		{
			System.out.println("created successfully");
		}
		else
		{
			System.out.println("invalid orgname");
		}
		 
	}

}

package vtiger.contactTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.Genericutilites.Baseclass;
import vTiger.ObjectRepository.ContinfoNamePage;
import vTiger.ObjectRepository.CreatenewContactPage;
import vTiger.ObjectRepository.DetailscontPage;
import vTiger.ObjectRepository.HomePage;
@Listeners(vTiger.Genericutilites.ListenersImplementationClass.class)
public class CreatenewContactTest extends Baseclass {
	@Test
	public void createNewContactTest() throws IOException
	  {
		String lastname=eutil.Readthedatafromexcelsheet("Contact",1,2)+jutil.random();
		//step2:click on contact button
		HomePage hp=new HomePage(driver);
		hp.clickoncontbutton();
		//step3:click on contact lookup icon
	 CreatenewContactPage cp1=new CreatenewContactPage(driver);
	 cp1.clickoncontlookupicon();
	 //step4:create contact with mandatory field
	 DetailscontPage dp1=new DetailscontPage(driver);
	 dp1.createcont(lastname);
	//Assert.fail();
	//step5:getting contact name for validation
	ContinfoNamePage cop=new ContinfoNamePage(driver);
	String contname=cop.getorgname();
	//validation
	Assert.assertTrue(contname.contains(lastname));
	 
	}


}

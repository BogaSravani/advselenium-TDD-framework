package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoNamePage {
 //locator for intialize elements
	public OrgInfoNamePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//locator to locate created new orgname
	@FindBy(className="dvHeaderText")
	private WebElement Corgname;
	public WebElement getCorgname()
	{
		return Corgname;
	}
	
	/*business library*/
	/*
	 * This method will return the create orgname
	 */
	public String takeorgname()
	{
		return getCorgname().getText();
	}
	
	
}

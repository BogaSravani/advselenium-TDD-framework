package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.Genericutilites.WebDriverutility;

public class DetailsorgPage extends WebDriverutility{
	//locator for intialize elements
	public DetailsorgPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//locator for orgname
	@FindBy(name="accountname")
	private WebElement neworgname;
	//locator for Industry Dropdown
	@FindBy(name="industry")
	private WebElement industry;
	//locator for user dropdown
	@FindBy(name="accounttype")
	private WebElement type;
	//save button
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	
	public WebElement getneworgname()
	{
		return neworgname;
	}
	public WebElement getindustry()
	{
		return industry;
	}
	public WebElement gettype()
	{
		return type;
	}
	public WebElement getsave()
	{
		return save;
	}
	/*business library*/
	/**
	 * this method is used to create new org with mandatory fields and save
	 */
	public void createneworg(String orgname)
	{
		neworgname.sendKeys(orgname);
		save.click();
	}
	/**
	 * this method is used to create new org along with industry and save
	 * @param orgname
	 * @param Industry
	 */
	public void createneworg(String orgname,String Industry)
	{
		neworgname.sendKeys(orgname);
		handledropdown(Industry,industry);
		save.click();
	}
	/**
	 * this method is used to create new org along with industry and type and save
	 * @param orgname
	 * @param Type
	 * @param type
	 */
	public void createneworg(String orgname,String Type,String Industry)
	{
		neworgname.sendKeys(orgname);
		handledropdown(Industry,industry);
		handledropdown(Type, type);
		save.click();
	}

}

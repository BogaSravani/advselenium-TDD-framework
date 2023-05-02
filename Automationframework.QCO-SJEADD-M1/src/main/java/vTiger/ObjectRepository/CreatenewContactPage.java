package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewContactPage {
	public CreatenewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    //locator for new contactbutton
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement newcontbutton;
	
	public WebElement getcontbutton()
	{
		return newcontbutton;
	}
	/**
	 * this method is used to click on new contact lookup icon
	 */
	public void clickoncontlookupicon()
	{
		newcontbutton.click();
	}
}

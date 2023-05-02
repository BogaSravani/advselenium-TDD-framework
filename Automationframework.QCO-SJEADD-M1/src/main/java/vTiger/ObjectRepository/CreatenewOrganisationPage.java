package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewOrganisationPage {
//constructor to intialize by using init elements
	public CreatenewOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//locator for create new organisation
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement neworg;
	
	public WebElement getneworg()
	{
		return neworg;
	}
	/*business library*/
	/*
	 * this method is used to click on create org lookup icon
	 */
	public void click()
	{
		neworg.click();
	}
	
	
}

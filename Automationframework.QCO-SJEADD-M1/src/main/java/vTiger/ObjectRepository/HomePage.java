package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.Genericutilites.WebDriverutility;

public class HomePage extends WebDriverutility{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//locator for orgname
	@FindBy(linkText="Organizations")
    private WebElement orgbutton;
	//locator for contact
	@FindBy(linkText="Contacts")
	private WebElement contbutton;
	//locate img of signout
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	//locate signout
	@FindBy(linkText="Sign Out")
	private WebElement logout;
		
	public WebElement getlogout()
	{
			return logout;
	}
	public WebElement getimgsignout()
	{
		return signoutimg;
	}
	
	
	//getter method for orgname
	public WebElement getorgbutton()
	{
		return orgbutton;
	}
	//getter method for contbutton
	public WebElement getcontbutton()
	{
		return contbutton;
	}
	/*business libraries*/
	/**
	 * this method with click on org button
	 */
	public void clickonorgbutton()
	{
		 orgbutton.click();
	}
	/**
	 * this method will click on contact button
	 */
	public void clickoncontbutton()
	{
		 contbutton.click();
	}
	/**
	 * click on signout
	 */
	public void signout(WebDriver driver)
	{
		movetoelement(driver,signoutimg);
		logout.click();
	}
}

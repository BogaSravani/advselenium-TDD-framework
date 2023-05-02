package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.Genericutilites.WebDriverutility;

public class DetailscontPage extends WebDriverutility{
	public DetailscontPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    //locator for lastname textfield
	@FindBy(name="lastname")
	private WebElement lastname;
	//locator for save button
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	//locator for org name in contact details page
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgname;
	//locator for sending orgname in searcbox
	@FindBy(id="search_txt")
	private WebElement searchbox;
	//locator for clicking on searchbutton
	@FindBy(name="search")
	private WebElement searchbutton;
	//driver.findElement(By.name("search")).click();
	public WebElement getlastname()
	{
		return lastname;
	}
	public WebElement getsave()
	{
		return savebutton;
	}
	public WebElement getorgname()
	{
		return orgname;
	}
	public WebElement getsearchbox()
	{
		return searchbox;
	}
	public WebElement getsearchbutton()
	{
		return searchbutton;
	}
	/*business library*/
	/**
	 * create cont with mandatory fields
	 * @param clastname
	 */
	public void createcont(String clastname)
	{
		lastname.sendKeys(clastname);
		savebutton.click();
	}
	/**
	 * create cont with organisation name
	 * @param driver
	 * @param clastname
	 */
	public void creatcont(WebDriver driver,String clastname,String corgname)
	{
		lastname.sendKeys(clastname);
		orgname.click();
		windowhandle(driver,"Accounts");
		searchbox.sendKeys(corgname);
		searchbutton.click();
		driver.findElement(By.xpath("//a[.='" + corgname + "']")).click();
		windowhandle(driver,"Contacts");
		savebutton.click();	
	}
	 
}

package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContinfoNamePage {
 public ContinfoNamePage(WebDriver driver)
 {
	 PageFactory.initElements(driver,this);
 }
 //locator for getting new created contact name
 @FindBy(className="dvHeaderText")
 private WebElement newcontname;
 public WebElement getcontname()
 {
	 return newcontname;
 }
 /**
  * this method will return created contname
 * @return 
  * 
  */
 public String getorgname()
 {
	return  newcontname.getText();
 }
}

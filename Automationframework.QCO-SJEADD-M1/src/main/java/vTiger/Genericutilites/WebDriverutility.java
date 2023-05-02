package vTiger.Genericutilites;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consisit of all the generic methods related to webdriver actions
 * @author boga sravani
 *
 */
 
public class WebDriverutility {
	/**
	 * this method is used to maximize the window
	 */
	 
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();	
	}
    /**
     * this method is used to minimize the window
     * @param driver
     */
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method is used to wait until page to load
	 * @param driver
	 */
	public void waitforpagetoload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * this method will wait for element to clickable
	 * @param driver
	 * @param wb
	 */
	public void elementtobeclickable(WebDriver driver,WebElement wb)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(wb));
	}
	/**
	 * @param driver
	 * this method is used to wait until visiblity of element
	 */
	public void elementtobevisible(WebDriver driver,WebElement wb)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	/**
	 * this method is used to select the option by using index
	 * @param wb
	 * @param index
	 */
	public void handledropdown(WebElement wb,int index)//method overloading
	{
		Select s=new Select(wb);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select the option by using value
	 * @param wb
	 * @param value
	 */
	public void handledropdown(WebElement wb,String value)//mwthod overloading
	{
		Select s=new Select(wb);
		s.selectByValue(value);
	}
	/**
	 * This method is used to select the option by using visibletext
	 * @param text
	 * @param wb
	 */
	public void handledropdown(String text,WebElement wb)//method overloading
	{
		Select s=new Select(wb);
		s.selectByVisibleText(text);
	}
	/**
	 * this method is used to move to an element
	 * @param driver
	 * @param element
	 */
	public void movetoelement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method is used to perform right click action on any point of webpage
	 * @param driver
	 */
	public void rightclick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method is used to perform right click action on particular webelement
	 * @param driver
	 * @param wb
	 */
	public void rightclick(WebDriver driver,WebElement wb)
	{
		Actions act=new Actions(driver);
		act.contextClick(wb).perform();
	}
	/**
	 * this method is used to perform drag and drop of element to element
	 * @param driver
	 * @param wb1
	 * @param wb2
	 */
	public void draganddrop(WebDriver driver,WebElement wb1,WebElement wb2)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(wb1,wb2).perform();
	}
	/**
	 * this method is used to drag and drop webelement on  particular point in webpage
	 * @param driver
	 * @param wb
	 * @param x
	 * @param y
	 */
	public void draganddrop(WebDriver driver,WebElement wb,int x,int y)
	{
		Actions act=new Actions(driver);
		act.dragAndDropBy(wb, x, y).perform();
	}
	/**
	 * this method will perform double click action at any point on webpage
	 * @param driver
	 */
	public void doubleclick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method is used to perform double click on particular element
	 * @param driver
	 * @param wb
	 */
	public void doubleclick(WebDriver driver,WebElement wb)
	{
		Actions act=new Actions(driver);
		act.doubleClick(wb).perform();
	}
	/**
	 * this method is used to perform enter by using robot class
	 * @throws AWTException
	 */
	public void pressenter() throws AWTException 
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to switch to frame by using index
	 * @param driver
	 * @param index
	 */
	public void switchtoframe(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used to perform switch to frame by using name or id value
	 * @param driver
	 * @param nameorId
	 */
	public void switchtoframe(WebDriver driver,String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	/**
	 * this method is used to switch to frame by using webelement
	 * @param driver
	 * @param wb
	 */
	public void switchtoframe(WebDriver driver,WebElement wb)
	{
		driver.switchTo().frame(wb);
	}
	/**
	 *this method is used to take screenshort of page 
	 * @param driver
	 * @param screenshotname
	 * @return 
	 * @throws IOException
	 */
	public String totakescreenshot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\Screenshot\\"+screenshotname+".png");
		FileUtils.copyFile(src, trg);
		return trg.getAbsolutePath();//used in extent reports
	}
	/**
	 * this method is used to perform random scroll
	 */
	public void scrollbyamount(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("Window.scrollby(0,500)"," ");
	}
	public void windowhandle(WebDriver driver,String partialtext)
	{
		//step1:capture all the sessionids
		Set<String> allid=driver.getWindowHandles();
		
		//step2:navigate to each page
		for(String id:allid)
		{
		//step3:switch to each window and capture the title
		String acttitle=driver.switchTo().window(id).getTitle();
		
		//step4:compare the title with required title
		if(acttitle.contains(partialtext))
		{
			break;
		}
		
	}
}

		}

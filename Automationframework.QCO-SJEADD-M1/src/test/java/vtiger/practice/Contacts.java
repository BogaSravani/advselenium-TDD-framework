package vtiger.practice;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import vTiger.Genericutilites.Baseclass;

public class Contacts extends Baseclass {
	Random r=new Random();
	int num=r.nextInt(100);
//@Test(priority=0)
public void createcontact()
{
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys("Ba"+num);
	 
}
//@Test(priority=1)
public void createorganisation()
{
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("qa"+num);
	 
}
//@Test(priority=2)
public void chemicals()
{
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("qb"+num);
	WebElement wb=driver.findElement(By.name("industry"));
	Select s=new Select(wb);
	s.selectByValue("Chemicals");
}
//@Test(priority=3)
public void energy()
{
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("qs"+num);
	WebElement wb=driver.findElement(By.name("industry"));
	Select s=new Select(wb);
	s.selectByValue("Energy");
	WebElement wb1=driver.findElement(By.name("accounttype"));
	Select s1=new Select(wb1);
	s1.selectByValue("Customer");
}
//@Test(priority=4)
public void contactorganisation()
{
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys("Ba"+num); 
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("qw"+num);
}
}

package vtiger.practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import vTiger.Genericutilites.Baseclass;

public class Organisation extends Baseclass{
	Random r=new Random();
	int num=r.nextInt(100);
	//@Test
	public void chemicals()
	{
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("q"+num);
		WebElement wb=driver.findElement(By.name("industry"));
		Select s=new Select(wb);
		s.selectByValue("Chemicals");
		
	}

}

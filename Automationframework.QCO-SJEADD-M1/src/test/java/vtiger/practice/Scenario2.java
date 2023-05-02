package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Properties pobj=new Properties();
		pobj.load(fis);
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh=book.getSheet("Organisation");
		Row r=sh.getRow(1);
		Cell c=r.getCell(2);
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys(pobj.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(pobj.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath(" //input[@name='accountname']")).sendKeys(c.getStringCellValue());
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(c.getStringCellValue()))
		{
			System.out.println("--pass--");
		}
		else
		{
			System.out.println("--fail--");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Signout successfull");
		
	}

}

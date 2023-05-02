package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Datafromproperty {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new EdgeDriver();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String browser=pobj.getProperty("browser");
		System.out.println(browser);
		String browser1=pobj.getProperty("url");
		System.out.println(browser1);
		
	}

}

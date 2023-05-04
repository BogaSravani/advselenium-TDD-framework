package vtiger.practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
@Test
public void Readdata()
{
	String Bvalue=System.getProperty("browser");
	System.out.println(Bvalue);
	
	String Uvalue=System.getProperty("url");
	System.out.println(Uvalue);
	
	String Pvalue=System.getProperty("password");
	System.out.println(Pvalue);
	String USvalue=System.getProperty("username");
	System.out.println(USvalue);
}
}

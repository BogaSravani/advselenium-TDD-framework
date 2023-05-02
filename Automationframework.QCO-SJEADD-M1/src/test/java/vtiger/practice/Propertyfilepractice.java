package vtiger.practice;

import java.io.IOException;

import vTiger.Genericutilites.ExcelsheetDataFileUtility;
import vTiger.Genericutilites.JavaUtility;
import vTiger.Genericutilites.PropertyFileUtility;

public class Propertyfilepractice {
	public static void main(String[] args) throws IOException {
		PropertyFileUtility p=new PropertyFileUtility();
		System.out.println(p.readDatafromPropertyfile("url"));
		ExcelsheetDataFileUtility f=new ExcelsheetDataFileUtility();
		System.out.println(f.Readthedatafromexcelsheet("organisation", 1, 2));
		//f.Writethedataintoexcelsheet("hlo2", 1, 2, "hloo");
		System.out.println("passed");
		JavaUtility j=new JavaUtility();
		System.out.println(j.getDateinsystemformat());
		
		
	}

}

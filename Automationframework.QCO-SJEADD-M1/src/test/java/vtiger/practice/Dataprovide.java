package vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovide{
	//@Test(dataProvider="getdata")
	public void apparel(String brandname,int price,int size)
	{
		System.out.println("brandname :"+brandname+","+" "+"price  :"+price+","+" "+"size  :"+size);
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] a=new Object[5][3];
		a[0][0]="nike";
		a[0][1]=2000;
		a[0][2]=30;
		
		a[1][0]="levis";
		a[1][1]=3000;
		a[1][2]=32;
		
		a[2][0]="adidas";
		a[2][1]=4000;
		a[2][2]=36;
		
		a[3][0]="crocodile";
		a[3][1]=5000;
		a[3][2]=38;
		
		a[4][0]="raymond";
		a[4][1]=3500;
		a[4][2]=32;
		
		return a;
	}

}

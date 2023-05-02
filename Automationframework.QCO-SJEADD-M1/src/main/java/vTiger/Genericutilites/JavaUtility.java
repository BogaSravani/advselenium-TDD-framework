package vTiger.Genericutilites;

import java.util.Date;
import java.util.Random;

/**
 * this class consist of all the generic java methods
* @author boga sravani
**/
public class JavaUtility {
	 /**
	  * This method will generate the random number for every run
	 * @return 
	  * @return
	  */
	public int random()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
	/**
	 * This method will generate the present date
	 * @return
	 */
	public String getsystemdate()
	{
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	public String getDateinsystemformat()
	{
		Date d=new Date();
		String darr[]=d.toString().split(" ");
		String day=darr[2];
		String month=darr[1];
		String year=darr[5];
		String time=darr[3].replace(":","-");
		String value=day+"-"+month+"-"+year+" "+time;
		return value;
	}

}

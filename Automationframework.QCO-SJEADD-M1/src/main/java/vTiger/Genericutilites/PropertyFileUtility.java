package vTiger.Genericutilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of generic methods related to propertyfiles
 * @author boga sravani
 *
 */

public class PropertyFileUtility {
	/**
	 * This method will read the data from the propertyfile
	 * @param key
	 * @return
	 * @throws IOException 
	 * @throws IO exception
	 */
	public String readDatafromPropertyfile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}
	

}

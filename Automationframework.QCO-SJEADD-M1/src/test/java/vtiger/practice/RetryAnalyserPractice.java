package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
 
	@Test(retryAnalyzer=vTiger.Genericutilites.RetryAnalyserImplementationClass.class)
	public void retryanalyzer()
	{
		Assert.fail();
		System.out.println("hi");
	}
}

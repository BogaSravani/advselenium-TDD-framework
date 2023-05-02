package vTiger.Genericutilites;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result)
	{
		String methodname=result.getMethod().getMethodName();
		test=report.createTest(methodname);
		test.log(Status.INFO,""+methodname+"---Test execution started---");
		 
	}
	public void onTestSuccess(ITestResult result)
	{
		String methodname=result.getMethod().getMethodName();
		test.log(Status.PASS,""+methodname+"---test execution passed-----");
	}
	public void onTestFailure(ITestResult result)
	{
		String methodname=result.getMethod().getMethodName();
		test.log(Status.FAIL,""+methodname+"---Test execution is failed----");
		test.log(Status.WARNING,result.getThrowable());
		
		/**take screenshot of faield testscripts*/
		String screenshotname=methodname+"-"+new JavaUtility().getDateinsystemformat();
		WebDriverutility wutil=new WebDriverutility();
		
		try {
			String path=wutil.totakescreenshot(Baseclass.ldriver,screenshotname);
			test.addScreenCaptureFromPath(path);//attach screenshot to report//
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result)
	{
		
		String methodname=result.getMethod().getMethodName();
		test.log(Status.SKIP,""+methodname+"---test execution skipped---");
		test.log(Status.INFO,result.getThrowable());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		 
	}
	public void onTestFailedWithTimeout(ITestResult result)
	{
		 
	}
	public void onStart(ITestContext context)
	{
		System.out.println("---suite excecution started----");
		/**configure the extent reports*/                                   //report-20-4-2023 9:36//
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getDateinsystemformat()+".html");
		htmlreport.config().setDocumentTitle("Vtiger Execution report");
		htmlreport.config().setDocumentTitle("qco-sjeadd-m1 automation report");
		htmlreport.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("basebrowser","firefox");
		report.setSystemInfo("base url","http://localhost:8888");
		report.setSystemInfo("base platform","window 10");
		report.setSystemInfo("Reporter name","sravani boga");
		
	}
	public void onFinish(ITestContext context)
	{
		System.out.println("---suite execution finished----");
		/**extent report gets generated*/
		report.flush();
	}
}

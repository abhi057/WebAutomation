package shoppingTests.reusableComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import shoppingTests.resources.ExtentReporter;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporter.getReportObject();
	@SuppressWarnings("rawtypes")
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal();
	
	

	@SuppressWarnings("unchecked")
	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}
    
	@Override
	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		// test.log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		String filePath = null;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

	}

    @Override
	public void onFinish(ITestContext context) {

		extent.flush();

	}

}

package shoppingTests.ExtentReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	ExtentReports extent;

@BeforeTest()	
public void config() {	
	String path = System.getProperty("user.dir")+ "\\reports\\index.html";
	
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Shopping Test Reports");
	reporter.config().setDocumentTitle("Test Results");
	
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Abhishek");
	
	
}
	
@Test	
public void initialDemo1() {
	ExtentTest test = extent.createTest("Login script 1");
	
	WebDriver driver = new ChromeDriver();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/client"); 

	driver.findElement(By.id("userEmail")).sendKeys("abhi@yahoo.com");
	driver.findElement(By.id("userPassword")).sendKeys("Qwerty@123");
	driver.findElement(By.id("login")).click();
	
	driver.quit();
	test.fail("Test fail demo");
	extent.flush();
	
	
	
}



}

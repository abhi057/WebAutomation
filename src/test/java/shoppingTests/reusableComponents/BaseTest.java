package shoppingTests.reusableComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import shoppingTests.pageObjects.LandingPage;

public class BaseTest {
	
	WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver initializeDriver()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	@BeforeMethod()
	public LandingPage launchApplication() {
		driver = initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.goTo();	
		return landingpage;
		
	}
	
	
	@AfterMethod()
	public void tearDown(){
		
		driver.quit();
	}

}

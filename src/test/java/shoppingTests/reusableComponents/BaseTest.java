package shoppingTests.reusableComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import shoppingTests.pageObjects.LandingPage;

public class BaseTest {
	
	WebDriver driver;
	
	public WebDriver initializeDriver()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	
	public LandingPage launchApplication() {
		driver = initializeDriver();
		LandingPage  landingpage = new LandingPage(driver);
		landingpage.goTo();	
		return landingpage;
		
	}

}

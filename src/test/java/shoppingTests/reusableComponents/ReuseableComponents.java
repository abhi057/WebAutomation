package shoppingTests.reusableComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shoppingTests.pageObjects.CartPage;

public class ReuseableComponents {
	
	
	WebDriver driver;
	public ReuseableComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//button[@class='btn btn-custom' and contains(@routerlink, 'cart')]")
	WebElement cartLink;
	
	
	public void waitForElementToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public void waitForElementToAppear(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	

	public void waitForElementToBeInvisible(By locator) throws InterruptedException {
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void waitForElementToBeInvisible() throws InterruptedException {
		
		Thread.sleep(3000);

	}
	
	
	public CartPage goToCartPage() throws InterruptedException {

	//	waitForElementToBeVisible(toastMsg);
	//	waitForElementToBeInvisible(spinner);
		waitForElementToBeInvisible();
		cartLink.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		

	}

}

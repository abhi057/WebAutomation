package shoppingsitetests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import shoppingTests.pageObjects.CartPage;
import shoppingTests.pageObjects.CheckOutPage;
import shoppingTests.pageObjects.ConfirmationPage;
import shoppingTests.pageObjects.LandingPage;
import shoppingTests.pageObjects.ProductsPage;
import shoppingTests.reusableComponents.BaseTest;

public class PlaceOrderTest extends BaseTest{

	@Test
	public void submitOrder() throws InterruptedException {
								
		LandingPage landingPage = launchApplication();	
		ProductsPage productsPage = landingPage.userLogin("abhi@yahoo.com", "Qwerty@123");	
		Thread.sleep(3000); 
		
		productsPage.addToCart();
		Thread.sleep(3000);
		
		CartPage cartPage = productsPage.goToCartPage();

	    Assert.assertTrue(cartPage.verifyProductDisplayed("ADIDAS ORIGINAL"));
	    
		CheckOutPage checkoutpage = cartPage.goToCheckOut();
		
		checkoutpage.selectCountry("India");
		
		ConfirmationPage confirmationPage = checkoutpage.submitOrder();
		
	    Assert.assertTrue(confirmationPage.verifyElementDisplayed());
		
		Thread.sleep(5000);
	//	driver.quit();

	}

}

package shoppingsitetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import shoppingTests.pageObjects.CartPage;
import shoppingTests.pageObjects.CheckOutPage;
import shoppingTests.pageObjects.ConfirmationPage;
import shoppingTests.pageObjects.ProductsPage;
import shoppingTests.reusableComponents.BaseTest;
import shoppingTests.reusableComponents.Retry;

public class ErrorValidations extends BaseTest{

	@Test(groups={"LoginError"},retryAnalyzer=Retry.class)
	public void loginErrorTest() throws InterruptedException {
					
		ProductsPage productsPage = landingpage.userLogin("abhi@yahoo.com", "incorrectPWD");	
		Assert.assertEquals("Incorrect email or passwor", landingpage.getErrorMsg());
	}
	
	
	@Test(groups={"ProductError"})
	public void productErrorTest() throws InterruptedException {
					
		ProductsPage productsPage = landingpage.userLogin("abhi@yahoo.com", "Qwerty@123");	
		Thread.sleep(3000); 	
		productsPage.addToCart();
		Thread.sleep(3000);
		CartPage cartPage = productsPage.goToCartPage();
	    Assert.assertFalse(cartPage.verifyProductDisplayed("PUMA INCORRECT PRODUCT"));    	
		Thread.sleep(5000);
	}
	


}

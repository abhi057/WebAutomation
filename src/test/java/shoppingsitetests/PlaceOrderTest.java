package shoppingsitetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import shoppingTests.pageObjects.CartPage;
import shoppingTests.pageObjects.CheckOutPage;
import shoppingTests.pageObjects.ConfirmationPage;
import shoppingTests.pageObjects.ProductsPage;
import shoppingTests.reusableComponents.BaseTest;

public class PlaceOrderTest extends BaseTest{

	@Test
	public void submitOrderTest() throws InterruptedException {
					
		ProductsPage productsPage = landingpage.userLogin("abhi@yahoo.com", "Qwerty@123");	
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
	}

}

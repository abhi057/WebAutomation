package shoppingsitetests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shoppingTests.pageObjects.CartPage;
import shoppingTests.pageObjects.CheckOutPage;
import shoppingTests.pageObjects.ConfirmationPage;
import shoppingTests.pageObjects.ProductsPage;
import shoppingTests.reusableComponents.BaseTest;
import shoppingTests.reusableComponents.OrderPage;

public class PlaceOrderTest extends BaseTest {

	@Test(dataProvider = "getData", groups = { "Smoke", "Purchase" })
	public void submitOrderTest(HashMap<String, String> input) throws InterruptedException {

		ProductsPage productsPage = landingpage.userLogin(input.get("email"), input.get("password"));
		Thread.sleep(3000);
		productsPage.addToCart();
		Thread.sleep(3000);
		CartPage cartPage = productsPage.goToCartPage();
		Assert.assertTrue(cartPage.verifyProductDisplayed(input.get("product")));
		CheckOutPage checkoutpage = cartPage.goToCheckOut();
		checkoutpage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutpage.submitOrder();
		Assert.assertTrue(confirmationPage.verifyElementDisplayed());
		Thread.sleep(5000);
	}

	@Test(dependsOnMethods = "submitOrderTest")
	public void orderHistory() throws InterruptedException {
		ProductsPage productsPage = landingpage.userLogin("abhi@yahoo.com", "Qwerty@123");
		Thread.sleep(3000);
		OrderPage orderPage = productsPage.goToOredrsPage();
		Assert.assertTrue(orderPage.verifyOrderDisplayed("ADIDAS ORIGINAL"));

	}


	@DataProvider
	public Object[][] getData() throws IOException {

		String userDir = System.getProperty("user.dir");
		System.out.println(System.getProperty("user.dir"));

		List<HashMap<String, String>> data = getJsonDataToMap(
				userDir + "//src//test//java//shoppingTests//data//PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };

//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "abhi@yahoo.com");
//		map.put("password", "Qwerty@123");
//		map.put("product", "ADIDAS ORIGINAL");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "incorrect@yahoo.com");
//		map1.put("password", "dummy");
//		map1.put("product", "something");

		// return new Object[][] {{map}};

	}

}

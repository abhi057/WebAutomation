package shoppingTests.pageObjects;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingTests.reusableComponents.ReuseableComponents;

public class CartPage extends ReuseableComponents {

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;

	
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement checkOutBtn;
	

	
	public Boolean verifyProductDisplayed(String productName)
	{
      Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));				
	  return match;
	}
	
	public CheckOutPage goToCheckOut() {
		checkOutBtn.click();
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
		}

	
		
}

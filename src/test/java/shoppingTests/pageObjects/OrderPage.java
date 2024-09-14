package shoppingTests.reusableComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
	WebDriver driver;
	public OrderPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css="tr td:nth-child(3")
	List<WebElement> productsOrdered;
	
	
	public Boolean verifyOrderDisplayed(String productName) {
		  Boolean match = productsOrdered.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		  return match;				
	}
	
	
	

}

package shoppingTests.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingTests.reusableComponents.ReuseableComponents;

public class ConfirmationPage extends ReuseableComponents{

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//h1[normalize-space()='Thankyou for the order.']")
	WebElement thankyouMsg;
	
	public Boolean verifyElementDisplayed()
	{
      Boolean match = thankyouMsg.isDisplayed();
	  return match;
	}

}

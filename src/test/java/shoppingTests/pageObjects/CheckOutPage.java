package shoppingTests.pageObjects;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingTests.reusableComponents.ReuseableComponents;

public class CheckOutPage extends ReuseableComponents {

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	

	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement submitBtn;
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class, 'ta-item')])[2]")
	WebElement selectCountry;
	
	
	public void selectCountry(String countryName) {

	Actions act = new Actions(driver);
	act.sendKeys(country, countryName).build().perform();
	waitForElementToBeVisible(By.cssSelector(".ta-results"));
	selectCountry.click();
	
	}
	
	public ConfirmationPage submitOrder() {
		submitBtn.click();
		return new ConfirmationPage(driver);
	}
	
	


		
}

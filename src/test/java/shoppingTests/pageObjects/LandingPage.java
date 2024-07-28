package shoppingTests.pageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingTests.reusableComponents.ReuseableComponents;

public class LandingPage extends ReuseableComponents {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	public ProductsPage userLogin(String email, String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();	
		ProductsPage productsPage = new ProductsPage(driver);
	    return productsPage;
	}
	
	
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
		
}

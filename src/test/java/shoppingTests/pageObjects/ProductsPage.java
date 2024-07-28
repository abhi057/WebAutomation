package shoppingTests.pageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;

import shoppingTests.reusableComponents.ReuseableComponents;

public class ProductsPage extends ReuseableComponents {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='btn btn-custom' and contains(@routerlink, 'cart')]")
	WebElement cartLink;

	By toastMsg = By.cssSelector("#toast-container");
	By spinner = By.cssSelector(".ng-animating");

	public void addToCart() {

		
		String addToCartBtn = "(//*[contains(text(),'Add To Cart')])";
		String productEle = "(//*[contains(text(),'ADIDAS')])";
		
		driver.findElement(RelativeLocator.with(By.xpath(addToCartBtn))
				.below(By.xpath(productEle))).click();
     
	}
	


}

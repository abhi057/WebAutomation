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

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client"); 

		driver.findElement(By.id("userEmail")).sendKeys("abhi@yahoo.com");
		driver.findElement(By.id("userPassword")).sendKeys("Qwerty@123");
		driver.findElement(By.id("login")).click();
		
		

		Thread.sleep(3000); 
		/* List<WebElement> products =
		 * driver.findElements(By.xpath("(//div[@class='card'])"));
		 * 
		 * prod = products.stream().filter(product ->
		 * product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3"))
		 * .findFirst().orElse(null); driver.navigate().refresh();
		 * prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 *
		 * 
		 * 
		 * 
		 * 
		 * for(WebElement product : products) {
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(product));
		 * if(product.findElement(By.cssSelector("b")).getText().contains("ZARA COAT 3"
		 * )) {
		 * 
		 * // wait.until(ExpectedConditions.visibilityOf(product));
		 * wait.until(ExpectedConditions.elementToBeClickable(product));
		 * product.findElement(By.cssSelector(".card-body button:last-of-type")).click()
		 * ; } }
		 */

		// click on Adidas Original using below  (//*[contains(text(),'View')])

		driver.findElement(RelativeLocator.with(By.xpath("(//*[contains(text(),'Add To Cart')])"))
				.below(By.xpath("(//*[contains(text(),'ADIDAS')])"))).click();
		
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.xpath("//button[@class='btn btn-custom' and contains(@routerlink, 'cart')]")).click();
		
		
	    List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));	
	   
	    Assert.assertTrue(cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase("ADIDAS ORIGINAL")));

		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
		
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    
		driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		
	    Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Thankyou for the order.']")).isDisplayed());
		
		Thread.sleep(5000);
		driver.quit();

	}

}

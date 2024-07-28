package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/edit");
		
		
		String xpath= "//input[@id='fullName']";
		driver.findElement(By.xpath(xpath)).sendKeys("Abhishek");
		
		Thread.sleep(3000);
		driver.quit();

	}

}

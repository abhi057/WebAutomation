import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {

	public static void main(String[] args) {
		
		System.out.println("Hello World!");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.quit();


	}

}

package commonClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	
	public static WebDriver setupDriver() {
		
		String exepPath = "./driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exepPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

}

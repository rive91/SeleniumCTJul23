package prueba;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo_ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Hola Selenium");
		String exePath = "./driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		Thread.sleep(2000);
		driver.manage().window().maximize(); //Maximizar Ventana
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement userNameTxt = driver.findElement(By.id("user-name"));
		
		driver.quit();

	}

}

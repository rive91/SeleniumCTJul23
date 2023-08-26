package Ejemplo_Soft_Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewTest {
  @Test
  public void Tc1() {
	  
	  SoftAssert softassert = new SoftAssert();
	  
	  System.out.println("Hola Selenium");
		String exePath = "./driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		String badTitle = "swaglabs";
		
		softassert.assertEquals(actualTitle, expectedTitle);
		softassert.assertEquals(actualTitle, badTitle);
		
		softassert.assertAll();
		
  }
}

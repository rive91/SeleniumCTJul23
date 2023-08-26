package loginTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonClasses.DriverSetup;
import commonClasses.GlobalVariables;
import commonClasses.WrapClass;
import navigationsPages.SauceLoginPage;

public class TC_01_Login {
	
	//Declarar e inicializar el webDriver
	WebDriver driver = DriverSetup.setupDriver();
	
	//PageObjects
	SauceLoginPage loginPage = new SauceLoginPage(driver);
	
	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}
	
	@Test
	public void TC_01() {
		loginPage.loginSauce(GlobalVariables.USER_NAME, GlobalVariables.PASSWORD);
	}
	
	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC_01");
		driver.quit();
	}
}

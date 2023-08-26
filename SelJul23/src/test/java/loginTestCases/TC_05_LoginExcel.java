package loginTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonClasses.DriverSetup;
import commonClasses.GlobalVariables;
import commonClasses.WrapClass;
import navigationsPages.SauceLoginPage;

public class TC_05_LoginExcel {
	
	//Declarar e inicializar el webDriver
	WebDriver driver = DriverSetup.setupDriver();
	
	//PageObjects
	SauceLoginPage loginPage = new SauceLoginPage(driver);
	
	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}
	
	@Test
	public void TC_05() {
		String user = WrapClass.getCellData("TC_05", 1, 0);
		String pwd =  WrapClass.getCellData("TC_05", 1, 1);

		loginPage.loginSauce(user,pwd);
	}
	
	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC_05");
		driver.quit();
	}
}

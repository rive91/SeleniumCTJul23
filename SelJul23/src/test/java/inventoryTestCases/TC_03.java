package inventoryTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonClasses.DriverSetup;
import commonClasses.GlobalVariables;
import commonClasses.WrapClass;
import navigationsPages.InventoryPage;
import navigationsPages.SauceLoginPage;

public class TC_03 {
	// Declarar e inicializar el webDriver
	WebDriver driver = DriverSetup.setupDriver();

	// PageObjects
	SauceLoginPage loginPage = new SauceLoginPage(driver);
	InventoryPage inventoryPage = new InventoryPage(driver);

	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}

	@Test
	public void TC_03_Inv() {
		loginPage.loginSauce(GlobalVariables.USER_NAME, GlobalVariables.PASSWORD);
		Assert.assertTrue(inventoryPage.addToCartAndVerifyRmvBtn());
	}

	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC_03");
		driver.quit();
	}
}

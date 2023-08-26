package navigationsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClasses.WrapClass;

public class InventoryPage {
	
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addBackPack;
	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement removeBackPack;
	
	public boolean addToCartAndVerifyRmvBtn() {
		WrapClass.click(addBackPack);
		return WrapClass.verifyelementDisplayed(removeBackPack);
	}

}

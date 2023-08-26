package navigationsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClasses.WrapClass;

public class SauceLoginPage {
	
	public SauceLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//LoginPage WebElements
	@FindBy (id = "user-name") 
	private WebElement userNameTxt;
	@FindBy (id = "password") 
	private WebElement pwdTxt;
	@FindBy (id = "login-button") 
	private WebElement loginBTN;
	@FindBy (xpath = "//h3[@data-test = 'error']") 
	private WebElement errolockLbl;
	
	//Metodos de LoginPage
	
	public void loginSauce(String user, String pwd) {
		WrapClass.sendKeys(userNameTxt, user);
		WrapClass.sendKeys(pwdTxt, pwd);
		WrapClass.click(loginBTN);
	}
	
	public boolean validateLockError(){
		boolean errorDisplayed = WrapClass.geText(errolockLbl).contains("Sorry, this user has been locked out.");
		return errorDisplayed;
	}
}

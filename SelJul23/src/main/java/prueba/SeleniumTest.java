package prueba;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Hola Selenium");
		String exePath = "./driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		Thread.sleep(2000);
		driver.manage().window().maximize(); //Maximizar Ventana
		
		//Obteniendo webElements la pagina web
		WebElement userNameTxt = driver.findElement(By.id("user-name"));
		WebElement pwdTxt = driver.findElement(By.name("password"));
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		
		//Haciendo Login
		userNameTxt.sendKeys("standard_user");
		Thread.sleep(500);
		pwdTxt.sendKeys("secret_sauce");
		Thread.sleep(500);
		loginBtn.click();
		Thread.sleep(500);
		
		//Metodos de explorador
		//Obterner titulo de la pagina actual
		String title = driver.getTitle();
		System.out.println("El titulo de pagina es: " + title);
		
		//Obtener URL
		String url = driver.getCurrentUrl();
		System.out.println("La URL actual es: " + url);
		
		//Metdos de navagacion
//		driver.navigate().back();
//		Thread.sleep(2000);
//		driver.navigate().forward();
//		Thread.sleep(2000);
//		driver.navigate().refresh();
		
		//Verificar Elemento desplegado
		boolean invetoryItemIsDisplayed = driver.findElement(By.className("inventory_item_name")).isDisplayed();
		
		if(invetoryItemIsDisplayed) {
			System.out.println("El articulo esta deplegado");
		}
		
		//Obtener texto de WebElement
		String itemName = driver.findElement(By.className("inventory_item_name")).getText();
		
		if(itemName.contains("Sauce Labs")) {
			System.out.println("El producto es correcto");
		}else {
			System.out.println("ERROR: el producto es incorrecto");
		}
		
		//DropDown
		Select oSelect = new Select(driver.findElement(By.xpath("//select[@data-test = 'product_sort_container']")));
		oSelect.selectByVisibleText("Price (high to low)");
		
		//FindElements
		List<WebElement> prodLists = driver.findElements(By.className("inventory_item_name"));
		System.out.println("Numero de elementos en la lista: " + prodLists.size());
		
		//String primerItem = prodLists.get(0).getText();
		//System.out.println(primerItem);

		//String segundoItem = prodLists.get(1).getText();
		//System.out.println(segundoItem);
		
		for(int i = 0; i < prodLists.size();i++) {
			System.out.println("Los productos son: " + prodLists.get(i).getText());
			if(!prodLists.get(i).getText().contains("Labs")) {
				System.out.println("ERROR: El producto no es un producto LABS valid0");
				break;
			}
		}
		//Cerrandor Navegador Web
		//driver.close();//Cierra la ventana/pestaña actual que el webdriver esta usando
		driver.quit();//Cerrar todas la ventanas que Selenium abrio 
	}

}

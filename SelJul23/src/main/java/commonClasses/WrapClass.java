package commonClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class WrapClass {

	public static void click(WebElement webE) {
		webE.click();
	}

	public static void sendKeys(WebElement webE, String textSend) {
		webE.sendKeys(textSend);
	}

	public static String geText(WebElement webE) {
		return webE.getText();
	}

	public static boolean verifyelementDisplayed(WebElement webE) {
		return webE.isDisplayed();
	}

	public static void takeScreenshot(WebDriver webdriver, String testCaseName) {

		// Toma el screenshot de la pagina sin formato
		File scrFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

		// Establecer donde se guarda el screenshot
		String screenshotPath = "./test-output/ExecutionResuls";

		try {
			FileHandler.createDir(new File(screenshotPath)); // Creamos el dolder usando la uta especificada de la
																// variable "screenshotPath"
			FileHandler.copy(scrFile, new File(screenshotPath + File.separator + testCaseName + ".png")); // Copiamos el
																											// Screenshot
																											// a la ruta
																											// creada
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getJsonValue(String jsonFileObk, String Jsonkey) {
		try {
			//JsonData
			InputStream inputStram = new FileInputStream(GlobalVariables.TEST_DATA + jsonFileObk + ".json"); //Utilizando la ruta para obtener el achivo JSON
			JSONObject jsonObject = new JSONObject (new JSONTokener(inputStram)); //Convirtiendo el archivo Json a un objeto de Java
			
			//Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonFileObk).getString(Jsonkey);
			return jsonValue;
		
	}catch (FileNotFoundException e) {
		return null;
	}
	}
	
	public static String getCellData(String excelName, int row, int column) {
		
		//leyendo datos/ecel
		try {
			FileInputStream fis = new FileInputStream(GlobalVariables.TEST_DATA + excelName + ".xlsx");
			
			//Construir un objeto en base al excel
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row rowObj = sheet.getRow(row);
			Cell cell = rowObj.getCell(column);
			
			String value = cell.getStringCellValue();
			return value;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}

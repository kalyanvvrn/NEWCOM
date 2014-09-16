package framework;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Refresh {
	public void refresh(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm)
			throws IOException, ParseException {
		String Status = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}

			webelement.sendKeys(Keys.F5);
			System.out.println("Refreshed the page");
			// driver.navigate().refresh();
		} catch (Exception e) {
		System.out.println(e.getMessage());	
		}
		}
	
}

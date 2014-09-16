package framework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Enter {

	public void enter(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm)
			throws InterruptedException {
		try {
			Thread.sleep(500);
			webelement.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

package framework;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHover {
	public void mouseHover(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application, String startTm, String endTm)
			throws IOException, ParseException {

		String Status = null;

		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
			Actions MoveHover = new Actions(driver);
			MoveHover.moveToElement(webelement).build().perform();

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				
				Results.results(testCaseno, testCaseDescription, Status, viewPort,
						application, startTm, endTm);
			}
		} catch (Exception e) {
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				
				Results.results(testCaseno, testCaseDescription, Status, viewPort,
						application, startTm, endTm);
			}
		}
	}
}
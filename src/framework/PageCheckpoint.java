package framework;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCheckpoint {

	public void pageCheckpoint(String viewPort, String functionality,
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

			if (driver.getTitle().equals(testData)) {
				System.out.println(testCaseno + " " + testCaseDescription
						+ " --Pass");
				Status = "Pass";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm);
			} else {

				Status = "Fail";
				System.out.println(testCaseno + " " + testCaseDescription
						+ " --Failed");
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm);
			}

		} catch (Exception e) {

			Status = "Fail";
			System.out.println(testCaseno + " " + testCaseDescription
					+ " --Failed");
			Results.results(testCaseno, testCaseDescription, Status, viewPort,
					application, startTm, endTm);

		}

	}
}

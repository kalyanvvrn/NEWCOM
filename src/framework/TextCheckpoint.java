package framework;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextCheckpoint {
	public void textCheckpoint(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm)
			throws IOException, ParseException {
		String Status = null;
		try {
			
			System.out.println(testCaseno+" "+testCaseDescription);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
			    driver.switchTo().window(Windowid);
			}

			
			Thread.sleep(500);
			System.out.println(webelement.getText());
			System.out.println(testData);
			if (webelement.getText().equals(testData)) {
				System.out.println(testCaseno+" "+testCaseDescription+"--PASS");

				Status = "Pass";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm);

			} else {
				System.out.println(testCaseno+" "+testCaseDescription+"--FAIL");
				Status = "Fail";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm);
			}

		} catch (Exception e) {

			Status = "Fail";
			System.out.println(testCaseno+" "+testCaseDescription+"--FAIL");
			Results.results(testCaseno, testCaseDescription, Status, viewPort,
					application, startTm, endTm);

		}

	}
}

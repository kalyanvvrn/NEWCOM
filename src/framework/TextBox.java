package framework;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBox {
	public void textBox(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,String oldValue, int j,
			String report, String application, String startTm, String endTm)
			throws InterruptedException, IOException, ParseException {
		
		String Status = null;
		try {
			
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}

			Thread.sleep(1000);

			// webelement.click();
			System.out.println(testCaseno+" Trying to enter " + testData
					+ " In to the text box ");
			webelement.sendKeys(testData);
			

			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				System.out.println(testCaseno+ " Entered " + testData
						+ " In to the text box sucessfully");
				Results.results(testCaseno, testCaseDescription, Status, viewPort,
						application, startTm, endTm);
			}
		
		} catch (Exception e) {
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				System.out.println(testCaseno+" " +
						"Not able to enter " + testData
						+ " In to the text box");
				Results.results(testCaseno, testCaseDescription, Status, viewPort,
						application, startTm, endTm);
			}
		}
	}
}

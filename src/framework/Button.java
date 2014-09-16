package framework;

import java.io.IOException;
import java.text.ParseException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button {
	public void button(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application,String startTm,String endTm) throws InterruptedException,
			IOException, ParseException {

		String Status = null;
		try {
			Thread.sleep(1000);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
			
			// this is to click on the webelement
			webelement.click();
			System.out.println(testCaseno+" "+testCaseDescription);
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Pass";
				Results.results(testCaseno, testCaseDescription, Status, viewPort,
						application, startTm, endTm);
			}
//this is catch statement
		} catch (Exception e) {
			System.out.println(testCaseno+" "+testCaseDescription+" --Failed");
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(testCaseno, testCaseDescription, Status, viewPort,
						application, startTm, endTm);
			}
		}
	}
}

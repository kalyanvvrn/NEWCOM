package framework;

import java.io.IOException;
import java.text.ParseException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComparingOldValue {
	public void comparingOldValue(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application,String startTm,String endTm) throws InterruptedException,
			IOException, ParseException {
		String Status = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
			Thread.sleep(4000);
			String NewValue = webelement.getText();
			System.out.println(NewValue);
			String value = oldValue;
			String TestDatavalue = testData;
			Float ActualNewValue = Float.parseFloat(NewValue);
			Float ActualoldValue = Float.parseFloat(value);
			Float ActualTestData = Float.parseFloat(TestDatavalue);
			
		
			if ((ActualoldValue + ActualTestData) == ActualNewValue) {
				System.out.println("Data is changed/added");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";
					
					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm,endTm);
				}
			}

			else {
				System.out.println("Data is not changed/added");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";
					
					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm,endTm);
				}
			}
		} catch (Exception e) {
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				
				Results.results(testCaseno, testCaseDescription, Status, viewPort,
						application, startTm,endTm);
			}
		}
	}
}

package framework;

import java.io.IOException;
import java.text.ParseException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataCheckpoint {
	public void dataCheckpoint(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm) throws InterruptedException,
			IOException, ParseException {
		String Status = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
			Thread.sleep(2000);
			if (webelement.getText().equals(testData)) {
				System.out.println(testCaseDescription
						+ " Displaying correctly as " + webelement.getText());
				
					Status = "Pass";
					
					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm,endTm);
				
			} else {
				System.out.println(testCaseDescription
						+ " Displaying incorrectly as " + webelement.getText());
				
					Status = "Fail";
					
					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm,endTm);
				
			}
		} catch (Exception e) {
			
				Status = "Fail";
				
				Results.results(testCaseno, testCaseDescription, Status, viewPort,
						application, startTm,endTm);
			
		}

	}
}

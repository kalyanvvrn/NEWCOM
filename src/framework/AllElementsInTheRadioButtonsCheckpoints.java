package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllElementsInTheRadioButtonsCheckpoints {
	public void allElementsInTheRadioButtonsCheckpoints(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm) throws IOException, ParseException {
		String Status = null;
		try {

			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
			}
 
			List<WebElement> List = webelement
					.findElements(By.tagName("input"));
			String[] Values = testData.split(",");
			int i = 0;
			for (WebElement Radioitem : List) {
				if (Radioitem.getText().equals(Values[i])) {
					i = i + 1;
				}
			}
			if (i == List.size()) {
				System.out.println("All radio Butotns are there");
				
					Status = "Pass";
					
					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm,endTm);
				
			} else {
				System.out.println("All Radio buttons are not there");
				
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

package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackButton {
	
	
	//This is to click on the back button
	public void backButton(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,String report,String application,String startTm) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.navigate().back();
	}
 
}

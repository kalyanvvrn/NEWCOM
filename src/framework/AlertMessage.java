package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertMessage {
	
	public void alertMessage(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm)
	{
		try
		{
			if(testData.toUpperCase().equals("ACCEPT"))
			{
				driver.switchTo().alert().accept();
				System.out.println("Clicked on the accept button");
			}
			else if(testData.toUpperCase().equals("DECLINE"))
			{
				driver.switchTo().alert().dismiss();
				System.out.println("Clicked on the decline button");
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Not able to click on the alert accept button");
		}
		
	}

}

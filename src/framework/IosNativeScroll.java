package framework;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class IosNativeScroll {

	public void iosNativeScroll(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    HashMap<String, String> scrollObject = new HashMap<String, String>();
	    scrollObject.put("element", ((RemoteWebElement) webelement).getId());
	    js.executeScript("mobile: scrollTo", scrollObject);
		
	}

}

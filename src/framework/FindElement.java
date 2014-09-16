package framework;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;

public class FindElement {

	public static WebElement find_Element(String ObjectIdentifierType,
			String ObjectIdentifier, WebDriver driver, 
			String viewPort, String testCaseno, String testCaseDescription,
			String application, String startTm, String endTm)
			throws IOException, ParseException { 

		String Status = null;
		WebElement webelement = null;

		
		if (!viewPort.toUpperCase().equals("APPIUM")) {
            String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
			}
		
        System.out.println("came to find element section");
		if (ObjectIdentifierType.toUpperCase().equals("XPATH")) {
			try {
				System.out.println(testCaseno+" Trying to identify object using XPATH started...");
				webelement = driver.findElement(By.xpath(ObjectIdentifier));
				System.out.println(testCaseno+" Identification of object using XPATH is done");
			} catch (Exception e) {
				System.out.println(testCaseno+" Identication of object using XPATH is failed!");
				Status = "Fail";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm);
			}
		}
		
		else if(ObjectIdentifierType.toUpperCase().equals("NAME"))
		{
try {
				System.out.println("came to name sections");
				System.out.println(testCaseno+" Trying to identify object using Name  started...");
				webelement = driver.findElement(By
						.name(ObjectIdentifier));
				System.out.println(testCaseno+" Identification of object using Name selector is done");
			} catch (Exception e) {
				System.out.println(testCaseno+" Identication of object using Name selctor is failed!");
				Status = "Fail";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm);
			}
		}
		
		else if (ObjectIdentifierType.toUpperCase().equals("CSS")) {
			try {
				
				System.out.println(testCaseno+" Trying to identify object using CSS selector started...");
				webelement = driver.findElement(By
						.cssSelector(ObjectIdentifier));
				System.out.println(testCaseno+" Identification of object using CSS selector is done");
			} catch (Exception e) {
				System.out.println(testCaseno+" Identication of object using css selctor is failed!");
				Status = "Fail";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm);
			}
		} else if (ObjectIdentifierType.toUpperCase().equals("ID")) {
			try {
				System.out.println(testCaseno+" Trying to identify object using ID started...");
				webelement = driver.findElement(By.id(ObjectIdentifier));
				System.out.println(testCaseno+" Identification of object using ID is done");
			} catch (Exception e) {
				Status = "Fail";
				System.out.println(testCaseno+" Identication of object using ID is failed!");
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm);
			}
		} else if (ObjectIdentifierType.toUpperCase().equals("TAG")) {
			try {
				System.out.println(testCaseno+" Trying to identify object using TAG started...");
				webelement = driver.findElement(By.tagName(ObjectIdentifier));
				System.out.println(testCaseno+" Identification of object using TAG is done");
			} catch (Exception e) {
				Status = "Fail";
				System.out.println(testCaseno+" Identication of object using TAG is failed!");
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm);
			}
		} else if (ObjectIdentifier.toUpperCase().equals("Class")) {
			try {
				System.out.println(testCaseno+" Trying to identify object using CLASS name started...");
				webelement = driver.findElement(By.className(ObjectIdentifier));
				System.out.println(testCaseno+" Identification of object using CLASS name is done");
			} catch (Exception e) {
				Status = "Fail";
				System.out.println(testCaseno+" Identication of object using CLASS name is failed!");
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm);
			}
		}

		return webelement;
	}
}

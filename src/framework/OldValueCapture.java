package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OldValueCapture {
	@SuppressWarnings("unused")
	public String oldValueCapture(WebElement webElement, WebDriver driver,
			String startTm) throws InterruptedException {
		String Status = null;
		try {

			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
			String Value = webElement.getText();
			System.out.println(Value);
			return Value;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}

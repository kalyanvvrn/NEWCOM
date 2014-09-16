package framework;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Selecting_Device {
	@SuppressWarnings({ })
	static
	WebDriver driver = null;
	static DesiredCapabilities capabilities = new DesiredCapabilities();

	@SuppressWarnings("deprecation")
	public static WebDriver selectdevice(String Driv) throws Exception {
		
		if (Driv.toUpperCase().equals("FIREFOX")) 
		return new FirefoxDriver();
		 else if (Driv.toUpperCase().equals("SAFARI"))
			return new SafariDriver();

		else if (Driv.toUpperCase().equals("ANDROID"))
			return new AndroidDriver();

		else if (Driv.toUpperCase().equals("APPAND"))
		{
		capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4");
		capabilities.setCapability(CapabilityType.PLATFORM, "MAC");

		try {
			driver = new RemoteWebDriver(
					new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			return driver;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		}
		else if(Driv.toUpperCase().equals("IOS"))
		
			return new IPhoneDriver();
		
		else if(Driv.toUpperCase().equals("APPIOS"))
		{ 
		capabilities.setCapability(CapabilityType.BROWSER_NAME,"iOS");
		capabilities.setCapability(CapabilityType.VERSION, "7.1");
		capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
		try {
			
			driver = new RemoteWebDriver(
					new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
		
			return driver;
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
			
		}
			
		}
		
		else if(Driv.toUpperCase().equals("SELENDROID"))
		{
			driver = new RemoteWebDriver(DesiredCapabilities.android());
			return driver;
		}
		else if(Driv.toUpperCase().equals("APPCHROME"))
		{
			capabilities.setCapability("device", "Android");
			capabilities.setCapability("deviceName", "Android");
			capabilities.setCapability(CapabilityType.VERSION, "4.4");
			capabilities.setCapability(CapabilityType.PLATFORM, "MAC");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", "chrome");
			
			try {
				//System.out.println("mobile chrome opened");
				driver = new RemoteWebDriver(new URL(
						"http://127.0.0.1:4723/wd/hub/"), capabilities);
				System.out.println("mobile chrome opened");
				return driver;
				
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
		
return new InternetExplorerDriver();

	}
	
}

package Base;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Baseclass {
	protected AndroidDriver driver;
	
	@BeforeMethod
	 public void LaunchApp() throws MalformedURLException
	{
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setApp("C:\\Selenium Projects\\General-Store.apk");
		options.setDeviceName("emulator-5554");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		
		
	}
	
	@AfterMethod
	public void CloseApp()
	{
		//driver.quit();
	}
}

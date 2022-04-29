package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.api.general.JavaScriptEventListener;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumMobileSiteTest {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testAppiumMobileApp() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");	
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		driver.get("https://appium.io/");
		
		
		//Get the steps for appium installation
		String installationSteps=driver.findElement(By.xpath("//*[@data-localize='install-code']")).getText();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", installationSteps);
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.close();
		
	}

}

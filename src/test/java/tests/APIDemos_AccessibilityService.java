package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_AccessibilityService {
	
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void testAccessibilityService() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(driver.findElement(By.xpath("//*[@text='Accessibility']")))).perform();
		action.tap(ElementOption.element(driver.findElement(By.xpath("//*[@text='Accessibility Service']")))).perform();
		
		String text=driver.findElement(By.xpath("//android.widget.TextView")).getText();
		
		Thread.sleep(2000);
		System.out.println(text);
		driver.quit();
		Thread.sleep(1000);
		
	}

}

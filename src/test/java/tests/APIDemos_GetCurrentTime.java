package tests;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class APIDemos_GetCurrentTime {
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void getCurrentTime() throws Exception
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","com.touchboarder.android.api.demos");
		cap.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.findElementByXPath("//*[@text='Views']").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextClock\"))");
		driver.findElementByXPath("//*[@text='TextClock']").click();
		String currentTime=driver.findElementsByClassName("android.widget.TextView").get(5).getText();
		System.out.println("Current time is: "+currentTime);
		driver.quit();
		
		
		
	}

}

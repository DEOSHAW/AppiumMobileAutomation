package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class APIDemos_Tabs {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testTabs() throws Exception
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("Views").click();
		Thread.sleep(1000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"))");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Tabs']")).click();
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("1. Content By Id").click();
		Thread.sleep(1000);
		String currentTab=driver.findElement(By.xpath("//*[@text='tab1']")).getText();
		System.out.println("You are in: "+currentTab);
		driver.quit();
		
		
		
		
	}

}

package tests;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class APIDemos_CheckBoxAndRadioButton {
	AppiumDriver<AndroidElement> driver;
	
	@Test
	void testAPIDemo() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","com.touchboarder.android.api.demos");
		cap.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
		driver=new AppiumDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		Thread.sleep(500);
		//driver.findElementById("com.touchboarder.android.api.demos:id/buttonDefaultPositive").click();
		Thread.sleep(2000);
		driver.findElementsById("android:id/text1").get(2).click();
		Thread.sleep(500);
		driver.findElementsById("android:id/text1").get(12).click();
		Thread.sleep(500);
		driver.findElementsById("android:id/text1").get(2).click();
		Thread.sleep(500);
		//driver.findElementById("com.touchboarder.android.api.demos:id/add").click();
		Thread.sleep(3000);
		String textAdded=driver.findElementById("com.touchboarder.android.api.demos:id/text").getText();
		System.out.println("The text is: "+textAdded);
		Thread.sleep(4000);
		
		
		
		
		
	}

}

package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class APIDemos_Views_Spinners {
	AndroidDriver<AndroidElement> driver;
	
	
	
	@Test
	void testDropDown() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		cap.setCapability("appPackage","com.touchboarder.android.api.demos");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		Thread.sleep(3000);
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Spinner\"))");
		Thread.sleep(800);
		driver.findElement(By.xpath("//*[@text='Spinner']")).click();
		Thread.sleep(800);
		driver.findElementById("io.appium.android.apis:id/spinner2").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Earth\"))");
		driver.findElement(By.xpath("//*[@text='Earth']")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}

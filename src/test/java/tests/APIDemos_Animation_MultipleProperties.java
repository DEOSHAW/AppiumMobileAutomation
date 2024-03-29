package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_Animation_MultipleProperties {
	AndroidDriver<AndroidElement> driver;
	
	
	
	@Test
	void testMultipleProperties() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		AndroidElement animationLink=driver.findElement(By.xpath("//*[@text='Animation']"));
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(animationLink)).perform();
		Thread.sleep(800);
		action.tap(ElementOption.element(driver.findElement(By.xpath("//*[@text='Multiple Properties']")))).perform();
		Thread.sleep(800);
		action.tap(ElementOption.element(driver.findElement(By.xpath("//*[@text='RUN']")))).perform();
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
	}

}

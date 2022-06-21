package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class Zoom_Test {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void joinWithInvalidId() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		cap.setCapability("appPackage","us.zoom.videomeetings");
		cap.setCapability("appActivity","com.zipow.videobox.LauncherActivity");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(driver.findElement(By.xpath("//*[@text='Join a Meeting']")))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@text='Meeting ID']")).sendKeys("5080433060");
		Thread.sleep(800);
		action.tap(ElementOption.element(driver.findElement(By.xpath("//*[@text='Join']")))).perform();
		Thread.sleep(1000);
		String errorText=driver.findElementById("us.zoom.videomeetings:id/txtMsg").getText();
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		System.out.println(errorText);
		if(errorText.contains("Invalid meeting ID"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
		
		
	}

}

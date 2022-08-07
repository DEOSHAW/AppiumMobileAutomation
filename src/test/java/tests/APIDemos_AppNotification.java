package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_AppNotification {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testAppNotification() throws Exception
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		TouchAction action=new TouchAction(driver);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		AndroidElement App=driver.findElementByAccessibilityId("App");
		action.tap(ElementOption.element(App)).perform();
		AndroidElement Notification=driver.findElement(By.xpath("//*[@text='Notification']"));
		action.tap(ElementOption.element(Notification)).perform();
		AndroidElement IncomingMessage=driver.findElement(By.xpath("//*[@text='IncomingMessage']"));
		action.tap(ElementOption.element(IncomingMessage)).perform();
		AndroidElement showAppNotification=driver.findElement(By.xpath("//*[@text='SHOW APP NOTIFICATION']"));
		
		Assert.assertEquals("SHOW APP NOTIFICATION", showAppNotification.getText());
		Thread.sleep(2500);
		driver.quit();
		
		
		
	}

}

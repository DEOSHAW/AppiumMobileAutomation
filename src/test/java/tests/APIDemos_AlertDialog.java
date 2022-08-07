package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_AlertDialog {
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void testOKCancelDialog() throws Exception 
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AndroidElement app=driver.findElement(By.xpath("//*[@text='App']"));
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(app)).perform();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@text='Alert Dialogs']")).click();
		Thread.sleep(500);
		driver.findElementByAccessibilityId("OK Cancel dialog with a message").click();
		String alertTitle=driver.findElementById("android:id/alertTitle").getText();
		if(alertTitle.contains("Lorem ipsum dolor sit aie consectetur adipiscing"))
		{
			Assert.assertEquals(alertTitle, "Lorem ipsum dolor sit aie consectetur adipiscing\n"
					+ "Plloaso mako nuto siwuf cakso dodtos anr koop.");
			driver.findElement(By.xpath("//*[@text='OK']")).click();
		}

		
		Thread.sleep(4000);
		driver.quit();
	}

}

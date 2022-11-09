package tests;

import java.net.MalformedURLException;
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

public class APIDemos_ProgressBar {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testProgressBar() throws Exception
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
		driver.findElement(By.xpath("//*[contains(@text,'Views')]")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Progress Bar\"))");
		//Accessbility id=content-desc
		AndroidElement progressBarElement=driver.findElementByAccessibilityId("Progress Bar");
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(progressBarElement)).perform();
		driver.findElementByAccessibilityId("1. Incremental").click();
		String titleText=driver.findElements(By.xpath("//android.widget.TextView")).get(0).getText();
		Assert.assertEquals(titleText, "Views/Progress Bar/1. Incremental");
		Thread.sleep(3000);
		driver.quit();
		
		
	}
}

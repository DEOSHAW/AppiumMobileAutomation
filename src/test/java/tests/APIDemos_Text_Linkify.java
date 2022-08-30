package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_Text_Linkify {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testLinkifyText()
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		TouchAction action=new TouchAction(driver);
		AndroidElement textElement=driver.findElement(By.xpath("//*[contains(@text,'Text')]"));
		action.tap(ElementOption.element(textElement)).perform();
		AndroidElement linkifyText=driver.findElement(By.xpath("//*[contains(@text,'Linkify')]"));
		action.tap(ElementOption.element(linkifyText)).perform();
		String text=driver.findElement(By.xpath("//*[contains(@text,'text4')]")).getText();
		System.out.println(text);
		driver.quit();
		
	}

}

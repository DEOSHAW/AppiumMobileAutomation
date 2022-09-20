package tests;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_Media_MediaPlayer {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testMediaPlayer() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		AndroidElement Media=driver.findElement(By.xpath("//*[@text='Media']"));
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(Media)).perform();
		AndroidElement MediaPlayer=driver.findElement(By.xpath("//*[@text='MediaPlayer']"));
		action.tap(ElementOption.element(MediaPlayer)).perform();
		
		List<AndroidElement> allMediaOptions=driver.findElements(By.xpath("//android.widget.Button"));
		for(AndroidElement mediaOption:allMediaOptions)
		{
			System.out.println(mediaOption.getText());
		}
		
		driver.quit();
		
		
		
		
		
		
	}

}

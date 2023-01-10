package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_ContentProvider {
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void getContentProviderOptions() throws Exception
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
		
		driver.findElement(By.xpath("//*[@text='Content']")).click();
		TouchAction action=new TouchAction(driver);
		AndroidElement providerElement=driver.findElement(By.xpath("//*[@text='Provider']"));
		action.tap(ElementOption.element(providerElement)).perform();
		AndroidElement pickContactElement=driver.findElement(By.xpath("//*[@text='Pick Contact']"));
		action.tap(ElementOption.element(pickContactElement)).perform();
		Thread.sleep(1500);
		
		List<AndroidElement> allOptions=driver.findElements(By.xpath("//*[@class='android.widget.Button']"));
		
		for(AndroidElement ele:allOptions)
		{
			System.out.println(ele.getText());
		}
		
		driver.quit();
		
		
	}

}

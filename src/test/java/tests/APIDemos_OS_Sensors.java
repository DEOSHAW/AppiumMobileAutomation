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

public class APIDemos_OS_Sensors {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void test_OS_Sensor() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AndroidElement OS=driver.findElement(By.xpath("//*[@text='OS']"));
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(OS)).perform();
		AndroidElement Sensors=driver.findElement(By.xpath("//*[@text='Sensors']"));
		action.tap(ElementOption.element(Sensors)).perform();
		
		String text=driver.findElement(By.xpath("//android.widget.TextView")).getText();
		Assert.assertEquals(text, "OS/Sensors");
		
		Thread.sleep(2500);
		driver.quit();
		
		
		
		
	}

}

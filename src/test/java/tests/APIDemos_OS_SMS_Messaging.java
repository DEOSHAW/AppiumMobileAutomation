package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.api.general.JavaScriptEventListener;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_OS_SMS_Messaging {
	
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void testSMSMessaging() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		//cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+File.separator+"ApiDemos-debug.apk");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		AndroidElement osElement=driver.findElement(By.xpath("//*[@text='OS']"));
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(osElement)).perform();
		driver.findElement(By.xpath("//*[@text='SMS Messaging']")).click();
		
		String disclaimerNote=driver.findElement(By.xpath("//*[contains(@text,'WARNING')]")).getText();
		System.out.println(disclaimerNote);
		
		
		
		
	}

}

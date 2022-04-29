package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Preference_ListPreference {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testListPreference() throws Exception
	{

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		//cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+File.separator+"ApiDemos-debug.apk");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		driver.findElementByAccessibilityId("Preference").click();
		Thread.sleep(800);
		driver.findElementByAccessibilityId("4. Default values").click();
		Thread.sleep(800);
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'List preference')]")).click();
		Thread.sleep(800);
		driver.findElementsById("android:id/text1").get(0).click();
		Thread.sleep(2000);
		driver.quit();
		
	}

}

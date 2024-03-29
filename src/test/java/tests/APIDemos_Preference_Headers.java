package tests;

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

public class APIDemos_Preference_Headers 
{
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void testPreferenceHeaders() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage", "io.appium.android.apis");
    	cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
    	
    	driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	AndroidElement Preference=driver.findElement(By.xpath("//*[@text='Preference']"));
    	TouchAction action=new TouchAction(driver);
    	action.tap(ElementOption.element(Preference)).perform();
    	driver.findElement(By.xpath("//*[contains(@text,'Headers')]")).click();
    	
    	List<AndroidElement> allPreferences=driver.findElements(By.id("android:id/summary"));
    	for(AndroidElement Pref:allPreferences)
    	{
    		System.out.println(Pref.getText());
    	}
    	
    	driver.quit();
    	
		
	}

}

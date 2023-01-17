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

public class Animation_LayoutAnimation {
	AndroidDriver<AndroidElement> driver;
	
    @Test
	void testAddButton() throws Exception
	{
    	
    	DesiredCapabilities cap=new DesiredCapabilities();
    	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
    	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "UiAutomator2");
    	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
    	cap.setCapability("appPackage", "io.appium.android.apis");
    	cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
    	
    	driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	TouchAction action=new TouchAction(driver);
    	
    	AndroidElement Animation=driver.findElement(By.xpath("//*[@text='Animation']"));
    	action.tap(ElementOption.element(Animation)).perform();
    	AndroidElement layoutAnimation=driver.findElement(By.xpath("//*[@text='Layout Animations']"));
    	action.tap(ElementOption.element(layoutAnimation)).perform();
    	driver.findElementById("io.appium.android.apis:id/addNewButton").click();
    	String buttonText=driver.findElement(By.xpath("//*[@text='1']")).getText();
    	Assert.assertEquals(buttonText, "1");
    	Thread.sleep(2500);
    	driver.quit();
    	
    	
    	
		
	}

}

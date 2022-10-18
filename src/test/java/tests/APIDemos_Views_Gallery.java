package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_Views_Gallery {
	AndroidDriver<AndroidElement> driver;
	
	
	
	@Test
	void navigateToGalleryPhotos() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AndroidElement Views=driver.findElement(By.xpath("//*[@text='Views']"));
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(Views)).perform();
		AndroidElement Gallery=driver.findElement(By.xpath("//*[@text='Gallery']"));
		action.tap(ElementOption.element(Gallery)).perform();
		AndroidElement Photos=driver.findElement(By.xpath("//*[contains(@text,'Photos')]"));
		action.tap(ElementOption.element(Photos)).perform();
		AndroidElement falseElement=driver.findElement(By.xpath("//*[@text='false']"));
		if(falseElement.isDisplayed())
		{
			System.out.println("Element Present");
		}
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}

}

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

public class APIDemos_Views_Buttons {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void validateAllButtons() throws Exception
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
		TouchAction action=new TouchAction(driver);
		AndroidElement Views=driver.findElement(By.xpath("//*[@text='Views']"));
		action.tap(ElementOption.element(Views)).perform();
		AndroidElement Buttons=driver.findElement(By.xpath("//*[@text='Buttons']"));
		action.tap(ElementOption.element(Buttons)).perform();
		AndroidElement Off=driver.findElement(By.xpath("//*[@text='OFF']"));
		action.tap(ElementOption.element(Off)).perform();
		
		String buttonText=driver.findElementById("io.appium.android.apis:id/button_toggle").getText();
		if(buttonText.equalsIgnoreCase("ON"))
		{
			System.out.println(buttonText);
			System.out.println("Button was pressed");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Button was not pressed");
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
		
		
	}

}

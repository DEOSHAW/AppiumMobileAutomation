package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class APIDemos_Views_Animation_3DTransition {
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void test3DTransition() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@text='Animation']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//android.widget.TextView[@text='3D Transition']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Lyon']")).click();
		if(driver.findElementsById("io.appium.android.apis:id/picture").size()>0)
		{
			System.out.println("3D Image is displayed");
		}
		else
		{
			System.out.println("3D Image is not displayed");
			Assert.assertTrue(false,"3D Image is not displayed");
		}
		
	
	}
	
	
	@AfterMethod
	void closeApp()
	{
		driver.quit();
		System.out.println("App closed");
	}

}

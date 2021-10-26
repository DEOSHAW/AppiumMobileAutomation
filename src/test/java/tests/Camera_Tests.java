package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Camera_Tests {
	
	@Test
	void testAndroidUIApp() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
		//cap.setCapability("udid","RZ8R22NGA2M");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		
		//Application info
		cap.setCapability("appPackage","com.android.camera2");
		cap.setCapability("appActivity","com.android.camera.CameraActivity");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		String st=driver.findElementByClassName("android.widget.TextView").getText();
		Thread.sleep(1000);
		driver.findElement(By.id("com.android.camera2:id/confirm_button")).click();
		
		
		System.out.println(st);
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}

package tests;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyDemoAPPTest {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testSearchProducts() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","com.saucelabs.mydemoapp.rn");
		cap.setCapability("appActivity","com.saucelabs.mydemoapp.rn.MainActivity");
		
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		List<AndroidElement> allProductsName=driver.findElementsByAccessibilityId("store item text");
		List<AndroidElement> allProductsPrice=driver.findElementsByAccessibilityId("store item price");
		if(allProductsName.size()==allProductsPrice.size())
		{
		for(int i=0;i<allProductsName.size();i++)
		{
			System.out.println(allProductsName.get(i).getText()+"==>"+allProductsPrice.get(i).getText());
		}
		}
		
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}

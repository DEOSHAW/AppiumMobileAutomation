package tests;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class APIDemos_ExpandableList {
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void testExpandableList() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		driver.findElement(By.xpath("//*[@content-desc='Expandable Lists']")).click();
		driver.findElement(By.xpath("//*[@text='1. Custom Adapter']")).click();
		
		List<AndroidElement> listOfItems=driver.findElements(By.className("android.widget.TextView"));
		Iterator<AndroidElement> itr=listOfItems.iterator();
		StringBuilder builder=new StringBuilder();
		while(itr.hasNext())
		{
			builder.append(itr.next().getText());
			builder.append("\n");
		}
		
		System.out.println(builder);
		driver.quit();
		
		
		
	}

}

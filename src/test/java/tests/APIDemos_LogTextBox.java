package tests;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class APIDemos_LogTextBox {
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void testLogTextBox() throws Exception
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		System.out.println("How many lines to add: ");
		Scanner scan=new Scanner(System.in);
		int noOfLines=scan.nextInt();
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		//Accessibility ID=content-desc
		driver.findElementByAccessibilityId("Text").click();
		driver.findElementByAccessibilityId("LogTextBox").click();
	    for(int i=0;i<noOfLines;i++)
	    {
		driver.findElementByAccessibilityId("Add").click();
	    }
	    String logText=driver.findElementById("io.appium.android.apis:id/text").getText();
	    
	    System.out.println("Log text is: "+logText);
	    
	    driver.quit();
		
		
		
		
		
		
	}

}

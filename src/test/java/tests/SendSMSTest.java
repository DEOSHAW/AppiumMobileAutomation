package tests;

import java.net.URL;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.remote.MobileCapabilityType;

public class SendSMSTest {
	AppiumDriver<WebElement> driver;
	WebElement nextButton;
	int count=0;
	
	@Test
	void testSendSMSFunction() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy M31");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage", "com.samsung.android.messaging");
		cap.setCapability("appActivity", "com.samsung.android.messaging.ui.view.main.WithActivity");
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<WebElement>(url,cap);
		
		clickOnNext("com.samsung.android.messaging:id/blackbird_first_launch_next_button");
		Thread.sleep(2000);
		Thread.sleep(700);
		driver.findElementById("com.samsung.android.messaging:id/fab").click();
		driver.findElementById("com.samsung.android.messaging:id/recipients_editor_to").sendKeys("758585");
		Thread.sleep(400);
		driver.findElementById("com.samsung.android.messaging:id/message_edit_text").sendKeys("This is automated message");
		Thread.sleep(400);
		driver.findElementById("com.samsung.android.messaging:id/send_button1").click();
		Thread.sleep(2000);
		driver.quit();
		
		
	}
	
	void clickOnNext(String id)
	{   try
	    {
		//if(count<3)
		//{
		nextButton=driver.findElementById(id);
		if(nextButton.isDisplayed())
		 {   nextButton.click();
		    // count++;
			clickOnNext(id);
			
		 }
	   // }
	    }
	    catch(org.openqa.selenium.NoSuchElementException e)
	    {
	    	System.out.println("Element no longer present");
	     }
		
	  
	}

}

package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Contacts_Emulator {
	
	AppiumDriver<MobileElement> driver;
	
	@Test
	void getContactDetails() throws Exception
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
		//cap.setCapability("udid","RZ8R22NGA2M");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		
		//Application info
		cap.setCapability("appPackage","com.android.contacts");
		cap.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,cap);
		String text=driver.findElementById("com.android.contacts:id/message").getText();
		System.out.println(text);
		Thread.sleep(3000);
		driver.quit();
	}

}

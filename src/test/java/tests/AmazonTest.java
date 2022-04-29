package tests;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonTest {
	AppiumDriver<MobileElement> driver;
	
	
	@Test
	void testCalendar() throws Exception
	{
		
		       //Device & Platform info
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M31");
				//cap.setCapability("udid","RZ8R22NGA2M");
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
				
				//Application info
				cap.setCapability("appPackage","in.amazon.mShop.android.shopping");
				cap.setCapability("appActivity","com.amazon.mShop.splashscreen.StartupActivity");
				
				
				URL url=new URL("http://127.0.0.1:4723/wd/hub");
				driver=new AppiumDriver<MobileElement>(url,cap);
				Thread.sleep(7000);
				MobileElement Logo=driver.findElementById("in.amazon.mShop.android.shopping:id/chrome_action_bar_home_logo");
				System.out.println(Logo.getAttribute("class"));
				Thread.sleep(3000);
				
		
	}

}

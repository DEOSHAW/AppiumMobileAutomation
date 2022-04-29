package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DialANumberScript {
	AppiumDriver<MobileElement> driver;
	
	@Test
	void testDialANumber() throws Exception
	{
		//Device & Platform info
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M31");
				cap.setCapability("udid","RZ8R22NGA2M");
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
				
				//Application info
				cap.setCapability("appPackage","com.samsung.android.dialer");
				cap.setCapability("appActivity","com.samsung.android.dialer.DialtactsActivity");
				
				
				URL url=new URL("http://127.0.0.1:4723/wd/hub");
				driver=new AppiumDriver<MobileElement>(url,cap);
				Thread.sleep(1000);
				
				//Dial Number
				//driver.switchTo().frame(0);
				driver.findElementById("com.samsung.android.dialer:id/seven").click();
				driver.findElementById("com.samsung.android.dialer:id/nine").click();
				driver.findElementById("com.samsung.android.dialer:id/eight").click();
				driver.findElementById("com.samsung.android.dialer:id/three").click();
				driver.findElementById("com.samsung.android.dialer:id/three").click();
				driver.findElementById("com.samsung.android.dialer:id/five").click();
				driver.findElementById("com.samsung.android.dialer:id/zero").click();
				
				Thread.sleep(800);
				driver.findElementById("com.samsung.android.dialer:id/dialButton").click();
				Thread.sleep(2000);
				
	}

}

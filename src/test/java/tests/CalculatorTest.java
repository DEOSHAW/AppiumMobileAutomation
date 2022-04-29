package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest {
	AppiumDriver<MobileElement> driver;
	
	@Test
	void testCalculator() throws Exception
	{
		//Device & Platform info
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M31");
		cap.setCapability("udid","RZ8R22NGA2M");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		
		//Application info
		cap.setCapability("appPackage","com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,cap);
		Thread.sleep(1000);
		driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07").click();
		Thread.sleep(2000);
		driver.findElementByClassName("android.widget.RelativeLayout").click();
		driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03").click();
		String result=driver.findElementById("com.sec.android.app.popupcalculator:id/calc_tv_result").getText();
		System.out.println("Result is: "+result);
		
		
		
		
		
		
		
		
	}

}

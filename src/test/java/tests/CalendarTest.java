package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalendarTest {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void getAllHolidaysInCurrentMonth() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		//Application info
		cap.setCapability("appPackage","com.samsung.android.calendar");
		cap.setCapability("appActivity","com.samsung.android.app.calendar.activity.MainActivity");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		String text=driver.findElements(By.className("android.view.View")).get(18).getText();
		System.out.println("****"+text+"*******");
		Thread.sleep(4000);
		driver.quit();
		
		
	}

}

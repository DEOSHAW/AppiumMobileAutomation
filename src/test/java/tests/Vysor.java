package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Vysor {
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void getVysorInfo() throws Exception
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","com.koushikdutta.vysor");
		cap.setCapability("appActivity","com.koushikdutta.vysor.StartActivity");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AndroidDriver<AndroidElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		String vysorInfo=driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Vysor shares your phone')]")).getText();
		System.out.println(vysorInfo);
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}

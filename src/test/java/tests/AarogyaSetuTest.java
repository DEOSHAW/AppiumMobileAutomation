package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class AarogyaSetuTest {
	
	AndroidDriver<MobileElement> driver;
	
	@Test
	void testAarogyaSetuApp() throws Exception
	{
		
		//Device & Platform info
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M31");
		//cap.setCapability("udid","RZ8R22NGA2M");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		
		//Application info
		cap.setCapability("appPackage","nic.goi.aarogyasetu");
		cap.setCapability("appActivity","nic.goi.aarogyasetu.views.SplashActivity");
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AndroidDriver<MobileElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		MobileElement langElement=driver.findElement(By.xpath("//*[contains(@text,'English')]"));
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(langElement)).perform();
		driver.findElement(By.xpath("//*[contains(@text,'Next')]")).click();
		String text=driver.findElementById("nic.goi.aarogyasetu:id/tv_each_one_of_us").getText();
		
		System.out.print("Text is: ");
		System.out.println("\n"+text);
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
	}

}

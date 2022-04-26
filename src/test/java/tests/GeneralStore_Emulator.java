package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class GeneralStore_Emulator {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void addProductToCart() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		
		//Application info
		cap.setCapability("appPackage","com.androidsample.generalstore");
		cap.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AndroidDriver<AndroidElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@text='Enter name here']")).sendKeys("Deo Shaw");
		Thread.sleep(500);
		AndroidElement submitButton=driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
		driver.findElement(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/spinnerCountry']")).click();
		Thread.sleep(500);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(submitButton)).perform();
		Thread.sleep(2000);
		String titleText=driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
		System.out.println("Title is: "+titleText);
		
		driver.quit();
		
	}

}

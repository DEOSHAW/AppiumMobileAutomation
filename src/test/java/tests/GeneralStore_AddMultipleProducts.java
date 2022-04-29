package tests;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class GeneralStore_AddMultipleProducts {
    AndroidDriver<AndroidElement> driver;
	
	@Test
	void test_addFourProducts() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Samsung Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
		
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/spinnerCountry']")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.xpath("//*[@text='Enter name here']")).sendKeys("Deo Shaw");
		AndroidElement shopButton=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']"));
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(shopButton)).perform();
		
		List<AndroidElement> products_first_set=driver.findElements(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productAddCart']"));
		System.out.println("Total number of products: "+products_first_set.size());
		for(AndroidElement product:products_first_set)
		{
			product.click();
			
		}
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))");
		List<AndroidElement> products_second_set=driver.findElements(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productAddCart']"));
		System.out.println("Total number of products: "+products_second_set.size());
		for(AndroidElement product:products_second_set)
		{
			product.click();
			
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		
		driver.quit();
		
		
	}

}

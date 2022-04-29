package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class PharmeasyTest {
	AppiumDriver<AndroidElement> driver;
	
	@Test
	void testPharmeasy() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M31");
		//cap.setCapability("udid","RZ8R22NGA2M");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		
		//Application info
		cap.setCapability("appPackage","com.phonegap.rxpal");
		cap.setCapability("appActivity","com.pharmeasy.ui.activities.SplashActivity");
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<AndroidElement>(url,cap);
		Thread.sleep(6500);
			
        driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='com.phonegap.rxpal:id/container_btnX']")).click();
           
		
		Thread.sleep(1500);
		if(driver.findElements(By.xpath("//android.widget.FrameLayout[@resource-id='com.phonegap.rxpal:id/container_btnX']")).size()>0)
            {
            	driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='com.phonegap.rxpal:id/container_btnX']")).click();
            }
		//driver.findElement(By.id("com.phonegap.rxpal:id/container_btnX")).click();
		//Thread.sleep(800);
		driver.findElement(By.id("com.phonegap.rxpal:id/container_btnX")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.phonegap.rxpal:id/lblSearchMedicine")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@text='Search medicines/OTC products @18% Off']")).sendKeys("Ecomoist");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.phonegap.rxpal:id/tv_variants_count']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.id("com.phonegap.rxpal:id/tv_medicine_name")).getText(), "Ecomoist Ultra Eye Drops 10ml");
		Thread.sleep(2000);
		driver.quit();
		
	}

}

package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MMT {
	
	AndroidDriver<MobileElement> driver;
	@Test
	void testMMT() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M31");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");	
		cap.setCapability("appPackage","com.makemytrip");
		cap.setCapability("appActivity","com.mmt.travel.app.home.ui.SplashActivity");
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.gms:id/credential_primary_label"))).click();
		Thread.sleep(500);
		driver.findElementById("com.makemytrip:id/title").click();
		Thread.sleep(1000);
		//driver.findElementById("com.makemytrip:id/search_button_flat").click();
		//android.widget.TextView
		//String text=driver.findElement(By.className("android.widget.TextView")).getText();
		
		//System.out.println(text);
		driver.quit();
		
		
	}

}

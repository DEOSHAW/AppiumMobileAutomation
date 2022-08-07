package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class WhartonTest {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void getWhartonMotto() throws MalformedURLException,InterruptedException
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.get("https://www.wharton.upenn.edu/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		AndroidElement motto=driver.findElement(By.xpath("//h6[contains(string(),'Wharton is changing the way business is done')]"));
		js.executeScript("arguments[0].scrollIntoView();",motto );
		
		Thread.sleep(2000);
		js.executeScript("alert(arguments[0])", motto.getText());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(800);
		driver.quit();
		
		
	}

}

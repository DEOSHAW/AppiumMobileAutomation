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

public class FileExplorerTest {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void findFiles() throws MalformedURLException, InterruptedException
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","com.android.documentsui");
		cap.setCapability("appActivity","com.android.documentsui.LauncherActivity");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		AndroidElement noItemsText=driver.findElement(By.xpath("//*[contains(@text,'No items')]"));
		System.out.println(noItemsText.getText());
		Thread.sleep(2000);
		driver.quit();
		
		
		
	}

}

package tests;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserTest_MaaVaishnoDevi {
	AndroidDriver<MobileElement> driver;
	
	@Test
	void testPlanAYatra() throws Exception
	{
		
		
		//Device & Platform info
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M31");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");	
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		cap.setCapability(MobileCapabilityType.BROWSER_VERSION,"101.0.4951.61");
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"chromedriver.exe");
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.get("https://www.maavaishnodevi.org/index.aspx");
		driver.findElement(By.xpath("//*[text()='Plan a Yatra']")).click();
		Thread.sleep(5000);
		
		String text=driver.findElement(By.xpath("//strong[text()='Rest of India to Jammu']")).getText();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", text);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.quit();
		
		
	}

}

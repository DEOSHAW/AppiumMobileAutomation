package tests;

import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Guru99Test {
	AndroidDriver<MobileElement> driver;
	
	
	@Test
	void testIframeScenarios() throws Exception
	{
		
		//Device & Platform info
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M31");
		//cap.setCapability("udid","RZ8R22NGA2M");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);	
		driver.get("http://demo.guru99.com/test/guru99home/");
		String parentWindow=driver.getWindowHandle();
		driver.switchTo().frame("a077aa5e");
		//driver.findElement(By.xpath("html/body/a/img")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("html/body/a/img")));
		Thread.sleep(2500);
		Set<String> winHandles=driver.getWindowHandles();
		Iterator<String> itr=winHandles.iterator();
		String text="";
		while(itr.hasNext())
		{
			String currentWindow=itr.next();
			if(!currentWindow.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(currentWindow);
				text=driver.findElement(By.xpath("//*[@class='entry-title' and contains(text(),'Selenium Live Project')]")).getText();
				break;
			}
		}
		
		js.executeScript("alert(arguments[0])", text);
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		driver.quit();
		
		
	}

}

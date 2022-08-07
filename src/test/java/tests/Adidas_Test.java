package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Adidas_Test {
	AndroidDriver<AndroidElement> driver;
	
	
	
	@Test
	void testAdidas() throws Exception
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.get("https://www.adidas-group.com/en/");
		driver.findElement(By.xpath("//*[@data-svg-id='hamburger']")).click();
		driver.findElement(By.xpath("//*[@title='About']")).click();
		driver.findElement(By.xpath("(//*[@title='Profile'])[1]")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		AndroidElement textElement=(AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Everything we do is rooted in sport.')]")));
		
		
		//wait.until(ExpectedConditions.visibilityOf(textElement));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", textElement);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", textElement);
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}

}

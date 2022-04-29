package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TeraData {
	AndroidDriver<WebElement> driver;
	
	@Test
	void getCareerInformation() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M31");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");	
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"chromedriver.exe");
		driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://careers.teradata.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@title='Show Navigation']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CAREERS HOME')]")).click();
		
		String careerText=driver.findElementByXPath("(//*[contains(text(),'Teradata is a community of people')])[2]").getText();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", careerText);
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		System.out.println("This is context: "+driver.getContextHandles());
		driver.quit();
		
	}

}

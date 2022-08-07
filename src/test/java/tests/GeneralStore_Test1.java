package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralStore_Test1 {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testLoginWithoutUserNameScenario() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Samsung Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.APP, "C:\\Selenium Projects\\General-Store.apk");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"10");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AndroidDriver<AndroidElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/spinnerCountry']")).click();
		//driver.findElementByAndroidUIAutomator("id(\"com.androidsample.generalstore:id/spinnerCountry\")").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")).click();
		String errorMessage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(errorMessage);
		
		Thread.sleep(2000);
		
	}

}

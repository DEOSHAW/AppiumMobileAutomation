package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Emulator_ClockTest {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testStopWatch() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator1");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		
		//Application info
		cap.setCapability("appPackage","com.android.deskclock");
		cap.setCapability("appActivity","com.android.deskclock.DeskClock");
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AndroidDriver<AndroidElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AndroidElement stopWatchLink=driver.findElementByXPath("//android.widget.TextView[@text='STOPWATCH']");
		TouchAction actions=new TouchAction(driver);
		actions.tap(new TapOptions().withElement(element(stopWatchLink))).perform();
		//stopWatchLink.click();
		driver.findElement(By.id("com.android.deskclock:id/stopwatch_hundredths_text")).click();
		Thread.sleep(3000);
		//driver.findElement(By.id("com.android.deskclock:id/stopwatch_time_wrapper")).click();
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}

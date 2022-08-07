package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_Animation_ViewFlip {
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void testViewFlip() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		//cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+File.separator+"ApiDemos-debug.apk");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		AndroidElement Animation=driver.findElement(By.xpath("//*[@text='Animation']"));
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(Animation)).perform();
		Thread.sleep(1000);
		AndroidElement viewFlip=driver.findElement(By.xpath("//*[@text='View Flip']"));
		action.tap(ElementOption.element(viewFlip)).perform();
		AndroidElement Flip=driver.findElement(By.xpath("//*[@text='FLIP']"));
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='FLIP']")));
		action.tap(ElementOption.element(Flip)).perform();
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}

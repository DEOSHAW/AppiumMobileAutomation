package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_NFC_ForegroundDispatch {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testForeGroundDispatch() throws Exception
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
		
		driver.findElementByAccessibilityId("NFC").click();
		AndroidElement ForegroundDispatchElement=driver.findElement(By.xpath("//*[@text='ForegroundDispatch']"));
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(ForegroundDispatchElement)).perform();
		String scanText=driver.findElement(By.xpath("//*[@text='Scan a tag']")).getText();
		System.out.println(scanText);
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
	}

}

package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_Preference {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testPreferenceHeaders() throws MalformedURLException
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
		
		TouchAction action=new TouchAction(driver);
		AndroidElement prefElement=driver.findElement(By.xpath("//*[@text='Preference']"));
		action.tap(ElementOption.element(prefElement)).perform();
		AndroidElement deafultValuesElement=driver.findElement(By.xpath("//*[contains(@text,'Default values')]"));
		action.tap(ElementOption.element(deafultValuesElement)).perform();
		
		List<AndroidElement> prefList= driver.findElements(By.id("android:id/title"));
		Iterator<AndroidElement> itr=prefList.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}
		
		driver.quit();
		
	}

}

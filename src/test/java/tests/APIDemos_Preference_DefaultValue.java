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

public class APIDemos_Preference_DefaultValue {
	AndroidDriver<AndroidElement> driver;
	
	
	@Test
	void checkDefaultListValue() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AndroidElement Preference=driver.findElement(By.xpath("//*[@text='Preference']"));
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(Preference)).perform();
		driver.findElement(By.xpath("//*[contains(@text,'Default')]")).click();
		driver.findElement(By.xpath("//*[contains(@text,'List')]")).click();
		AndroidElement disabledOption=driver.findElement(By.xpath("//*[contains(@text,'Alpha Option 01')]"));
		System.out.println(disabledOption.isEnabled());
		System.out.println(disabledOption.getText()+" is disabled");
		AndroidElement enabledOption=driver.findElement(By.xpath("//*[contains(@text,'Beta Option 02')]"));
		if(enabledOption.isEnabled())
		{
			System.out.println(enabledOption.isEnabled());
			System.out.println(enabledOption.getText()+" is enabled");
		}
		
		Thread.sleep(1500);
		driver.quit();
		
		
	}

}

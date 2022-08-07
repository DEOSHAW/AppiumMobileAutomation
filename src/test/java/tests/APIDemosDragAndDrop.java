package tests;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemosDragAndDrop {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testDragAndDropFeature() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		//cap.setCapability("appPackage","com.touchboarder.android.api.demos");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		Thread.sleep(7000);
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.findElementsById("android:id/text1").get(2).click();
		Thread.sleep(500);
		//driver.findElement(By.xpath("//*[@text='Views']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@text='Expandable Lists']")).click();
		Thread.sleep(1000);
		
		AndroidElement source=driver.findElementById("com.touchboarder.android.api.demos:id/drag_dot_1");
		AndroidElement target=driver.findElementById("com.touchboarder.android.api.demos:id/drag_dot_2");
		
		try
		{
		TouchAction t=new TouchAction(driver);
		t.longPress(element(source)).moveTo(element(target)).release().perform();
		}
		catch(Exception e)
		{
			System.out.println("Exception Encountered");
		}
		Thread.sleep(4000);
		driver.quit();
		
		
	}

}

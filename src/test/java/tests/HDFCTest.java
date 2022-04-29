package tests;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HDFCTest {
	AppiumDriver<MobileElement> driver;
	JavascriptExecutor js;
	
	@Test
	public void testShowAlert() throws Exception
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M31");
		//cap.setCapability("udid","RZ8R22NGA2M");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		
		//Application info
		cap.setCapability("appPackage","com.snapwork.hdfc");
		cap.setCapability("appActivity","com.hdfc.retail.netbanking.HDFCBank");
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,cap);
		driver.findElementById("com.snapwork.hdfc:id/btnSkipSetUp").click();
		Thread.sleep(500);
		driver.findElementById("com.snapwork.hdfc:id/btnSkipSetUp").click();
		Thread.sleep(500);
		driver.findElementById("com.android.permissioncontroller:id/permission_deny_button").click();
		Thread.sleep(500);
		driver.findElementById("com.android.permissioncontroller:id/permission_deny_button").click();
		Thread.sleep(5000);
		
		Dimension  size = driver.manage().window().getSize();
		int x1 = (int) (size.width * 0.60);
		  int y1 = (int) (size.height * 0.60);
		  TouchAction action=new TouchAction((MobileDriver) driver).longPress(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10))).perform();
		  
		//accessibilty id=content-desc
	    driver.findElementById("forgotId").click();
		//String text=driver.findElementByClassName("android.widget.Button").getText();
		js=(JavascriptExecutor)driver;
		//js.executeScript("alert(arguments[0])", alertText);
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		Thread.sleep(1500);
		driver.quit();
		
     }

}

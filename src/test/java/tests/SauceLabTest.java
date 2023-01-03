package tests;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;

public class SauceLabTest {
	
	
	@Test
	void testSauceLabDemoApp() throws Exception
	{
		
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName","Android");
		caps.setCapability("appium:deviceName","Android GoogleAPI Emulator");
		caps.setCapability("appium:deviceOrientation", "portrait");
		caps.setCapability("appium:platformVersion","12.0");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:app", "storage:filename=mda-1.0.16-19.apk");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("build", "appium-build-IT7QX");
		sauceOptions.setCapability("name", "DemoAppTest");
		caps.setCapability("sauce:options", sauceOptions);
		
		
		URL url = new URL("https://oauth-deoshaw3.it-d78ef:00decab2-b70b-444a-ae9a-2048217477bf@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		AppiumDriver driver = new AndroidDriver(url, caps);
		Thread.sleep(1000);
		
		List<WebElement> allProducts=driver.findElements(By.xpath("//android.widget.TextView"));
		for(int i=0;i<allProducts.size();i++)
		{
			System.out.println(allProducts.get(i).getText());
		}
		driver.quit();
		
	}

}

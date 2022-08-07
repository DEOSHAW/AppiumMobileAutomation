package tests;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MMT {
	
	AndroidDriver<MobileElement> driver;
	@Test
	void testMMT() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Galaxy M31");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");	
		cap.setCapability("appPackage","com.makemytrip");
		cap.setCapability("appActivity","com.mmt.travel.app.home.ui.SplashActivity");
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.gms:id/credential_primary_label"))).click();
		Thread.sleep(4000);
		//driver.findElementByAccessibilityId("com.makemytrip:id/title").click();
		//Thread.sleep(3000);
		driver.findElementsByClassName("android.widget.RelativeLayout").get(5).click();
		Thread.sleep(1000);
		driver.findElementById("com.makemytrip:id/search_button_flat").click();
		Thread.sleep(3000);
		driver.findElementById("com.makemytrip:id/snack_bar_footer_left").click();
		Thread.sleep(2000);
		List<MobileElement> flights=driver.findElements(By.id("com.makemytrip:id/airline_name"));
		Iterator<MobileElement> itr=flights.iterator();
		StringBuilder listOfFlights=new StringBuilder();
		while(itr.hasNext())
		{
			listOfFlights.append(itr.next().getText());
			listOfFlights.append("\n");
		}
		System.out.println("Below flights are available: ");
		System.out.println(listOfFlights);
		
		driver.quit();
		
		
	}

}

package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class PGATour_Test {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void getTheFedExCupLeader() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.get("https://www.pgatour.com/");
		driver.findElement(By.xpath("//*[@title='Want more?']")).click();
		driver.findElement(By.xpath("//a[normalize-space(text())='FedExCup']")).click();
		driver.findElement(By.xpath("//a[normalize-space(text())='Official Standings']")).click();
		WebDriverWait wait=new WebDriverWait(driver,8);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='FedExCup Standings']")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		AndroidElement topPlayer=driver.findElement(By.xpath("(//td[@class='player-name'])[1]"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", topPlayer);
		Thread.sleep(2500);
		driver.quit();
		
		
		
	}

}

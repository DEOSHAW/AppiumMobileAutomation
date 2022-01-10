package tests;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.events.api.general.JavaScriptEventListener;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralStore_AddProductToCart {
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void addProductToCart() throws Exception
	{
		//Process p = Runtime.getRuntime().exec("cmd /c start \"C:\\Users\\deosh\\Desktop\\StartAppium.bat\""); 
		//String[] command = {"cmd.exe", "/C", "Start", "C:\\Users\\deosh\\Desktop\\StartAppium.bat"};
		//Process p =  Runtime.getRuntime().exec(command);  
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Samsung Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		cap.setCapability(MobileCapabilityType.APP, "C:\\Selenium Projects\\General-Store.apk");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"10");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/spinnerCountry']")).click();
		//driver.findElementByAndroidUIAutomator("id(\"com.androidsample.generalstore:id/spinnerCountry\")").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.xpath("//*[@text='Enter name here']")).sendKeys("Deo Shaw");
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")).click();
		//Get number of products visible on mobile
		List<AndroidElement> productsList=driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		List<AndroidElement> addToCartList=driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
		int noOfProducts=productsList.size();
		System.out.println("Number of visible products is: "+noOfProducts);
		for(int i=0;i<noOfProducts;i++)
		{
			if(productsList.get(i).getText().equalsIgnoreCase("Air Jordan 1 Mid SE"))
			{
				addToCartList.get(i).click();
				break;
			}
		}
		AndroidElement cartElement=driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(cartElement));
		cartElement.click();
		driver.findElement(By.className("android.widget.CheckBox")).click();
		String addedProduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		System.out.println("Product added in the basket: "+addedProduct);
		Thread.sleep(1000);
		//Click on visit to website to complete purchase
		driver.findElement(By.xpath("//*[@text='Visit to the website to complete purchase']")).click();
		Thread.sleep(5000);
		Set<String> contextHandles=driver.getContextHandles();
		for(String handle:contextHandles)
		{
			if(handle.contains("WEBVIEW"))
			{
				//System.out.println(handle);
				driver.context(handle);
				break;
			}
		}
		Thread.sleep(2000);
		
		WebElement searchBox=driver.findElement(By.xpath("//*[@type='search']"));
		searchBox.sendKeys("Appium");
		Thread.sleep(1000);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		driver.findElement(By.xpath("//*[@text='Enter name here']")).sendKeys("Deo Shaw");
		
		driver.quit();
		
		
	}

}

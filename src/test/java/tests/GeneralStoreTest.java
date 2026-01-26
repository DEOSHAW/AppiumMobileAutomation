package tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import io.appium.java_client.AppiumBy;

public class GeneralStoreTest extends Baseclass
{
	@Test
	void NavigateToShoppingPage() throws InterruptedException
	{
		driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true))" +
			    ".scrollIntoView(new UiSelector().text(\"Australia\"))"
			)).click();
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Deo Shaw");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		String title=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"))).getText();
		Assert.assertEquals(title, "Products");
		//Scroll to the bottom of the screen
		WebElement ele=driver.findElement(By.id("android:id/content"));
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("element", ele); // Pass the WebElement itself
        params.put("direction", "down"); // or "up", "left", "right"
        params.put("percent", 1.0);
        for (int i = 0; i < 4; i++) {
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params);
        }
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Nike SFB Jungle']")).getText(), "Nike SFB Jungle");
	}
}

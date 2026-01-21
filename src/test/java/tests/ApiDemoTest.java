package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.functions.ExpectedCondition;

public class ApiDemoTest extends Baseclass
{
	@Test
	void NavigateToShoppingPage()
	{
		driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true))" +
			    ".scrollIntoView(new UiSelector().text(\"Australia\"))"
			)).click();
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Deo Shaw");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		WebElement screenTitle=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(screenTitle));
		String title=screenTitle.getText();
		Assert.assertEquals(title, "Products");
	}
}

package pageobject;


import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosAccessibility 
{
	AndroidDriver driver;
	
	public ApiDemosAccessibility(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Accessibility\")")
	WebElement accessibilityLink;
	
	@AndroidFindBy(accessibility = "Accessibility Node Provider")
	WebElement nodeProviderLink;
	
	@AndroidFindBy(accessibility = "Enable TalkBack and Explore-by-touch from accessibility settings. Then touch the colored squares.")
	WebElement nodeProviderInfoText;
	
	
	
	public String navigateToNodeProvider() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(accessibilityLink)).click();
		nodeProviderLink.click();
		String infoText=nodeProviderInfoText.getText();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.navigate().back();
		Thread.sleep(1000);
		return infoText;
		
	}
}

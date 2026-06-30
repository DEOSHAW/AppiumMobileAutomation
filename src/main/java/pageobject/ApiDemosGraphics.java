package pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosGraphics 
{
	AndroidDriver driver;
	
	public ApiDemosGraphics(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Graphics\"]")
	WebElement graphicsLink;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Drawable\"]")
	WebElement drawableLink;
	
	public String navigateToDrawableLink() throws InterruptedException
	{
		graphicsLink.click();
		Thread.sleep(1000);
		return drawableLink.getText();
	}
	
	

}

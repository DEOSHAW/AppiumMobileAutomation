package pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosAnimation
{
    AndroidDriver driver;
	
	public ApiDemosAnimation(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		
	}
	
	@AndroidFindBy(accessibility = "Animation")
	WebElement animationLink;
	
	@AndroidFindBy(accessibility = "Bouncing Balls")
	WebElement bouncingBallsLink;
	
	@AndroidFindBy(id = "android:id/navigationBarBackground")
	WebElement colouredBackground;
	
	public boolean isBouncingBallBackgroundPresent()
	{
		animationLink.click();
		bouncingBallsLink.click();
		return colouredBackground.isDisplayed();
	}
	

}

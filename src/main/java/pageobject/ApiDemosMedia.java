package pageobject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosMedia 
{
	AndroidDriver driver;
	
	public ApiDemosMedia(AndroidDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}
	
	@AndroidFindBy(id="android:id/text1")
	List<WebElement> allMediaOptions; 
	
	public List<String> navigateMediaFlow()
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Media\")")).click();
		
		List<String> mediaList=new ArrayList<String>();
		for(WebElement media: allMediaOptions)
		{
			mediaList.add(media.getText());
		}
		return mediaList;
	}

}

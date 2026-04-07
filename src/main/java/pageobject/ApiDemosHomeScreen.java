package pageobject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosHomeScreen 
{
	AndroidDriver driver;
	public ApiDemosHomeScreen(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		
	}
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1']")
	List<WebElement> homePageOptions;
	
	public List<String> getHomePageOptions()
	{
		List<String> allOptions=new ArrayList<String>();
		for(WebElement ele:homePageOptions)
		{
			allOptions.add(ele.getText());
		}
		return allOptions;
	}
	
	

}

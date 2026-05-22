package pageobject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosApp 
{
	AndroidDriver driver;
	
	public ApiDemosApp(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}
	
	@AndroidFindBy(accessibility = "App")
	WebElement appLink;
	
	@AndroidFindBy(accessibility = "Action Bar")
	WebElement actionBarLink;
	
	@FindBy(xpath="//*[@resource-id='android:id/text1']")
	List<WebElement> allActions; 
	
	public List<String> getAllActions()
	{
		appLink.click();
		actionBarLink.click();
		List<String> actionList=new ArrayList<String>();
		for(WebElement action:allActions)
		{
			actionList.add(action.getText());
		}
		return actionList;
		
	}
	

}

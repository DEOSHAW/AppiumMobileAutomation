package pageobject;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosPreferences 
{
	AndroidDriver driver;
	
	public ApiDemosPreferences(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Preference\")")
	WebElement preferencesLink;
	
	@AndroidFindBy(id = "android:id/text1")
	List<WebElement> preferencesList;
	
	
	
	public List<String> getPreferences()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(preferencesLink)).click();
		List<String> allPreferences=new ArrayList<String>();
		for(WebElement preference: preferencesList)
		{
			allPreferences.add(preference.getText());
		}
		return allPreferences;
	}
}

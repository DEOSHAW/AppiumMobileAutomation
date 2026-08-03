package pageobject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosViews 
{
	AppiumDriver driver;

    public ApiDemosViews(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Views']")
    RemoteWebElement viewsLink;

    @AndroidFindBy(className =  "android.widget.TextView")
    List<WebElement> viewsList;

    public List<String> getViews() 
    {
    	driver.executeScript("mobile: clickGesture", 
    	        Map.of("elementId", viewsLink.getId()));
    	List<String> viewsTextList=new ArrayList<>();
    	for(WebElement view:viewsList)
    	{
    		viewsTextList.add(view.getText());
    	}
		return viewsTextList;

     }
}

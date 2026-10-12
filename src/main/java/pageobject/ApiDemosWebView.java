package pageobject;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosWebView
{
	AndroidDriver driver;
	
	public ApiDemosWebView(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Views\"]")
    WebElement viewsLink;
	
	@AndroidFindBy(accessibility ="WebView")
    List<WebElement> webViewLink;
	
	
	public String navigateToWebView()
	{
		viewsLink.click();
		Map<String,Object> args = new HashMap<>(); 
		args.put("elementId",((RemoteWebElement)driver.findElement(AppiumBy.id("android:id/list"))).getId()); 
		// here the element is the scrollable area which is the parent element having scrollable true
		args.put("direction","down"); 
		args.put("percent",0.75); 
		while(webViewLink.isEmpty())
	    {
	        boolean canScrollMore = (Boolean) driver.executeScript(
	            "mobile: scrollGesture", args);

	    }
		return webViewLink.get(0).getText();
	}
	
	
	

}

package pageobject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosContent 
{
    AndroidDriver driver;
	
	public ApiDemosContent(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Content\"]")
	WebElement contentLink;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1']")
	List<WebElement> contentList;
	
	public List<String> getAllContent()
	{
		contentLink.click();
		Iterator<WebElement> itr=contentList.iterator();
		List<String> allContent=new ArrayList<>();
		while(itr.hasNext())
		{
			allContent.add(itr.next().getText());
		}
		return allContent;
	}
}

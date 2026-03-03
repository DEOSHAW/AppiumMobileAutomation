package pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Heroku 
{
	AndroidDriver driver;
	public Heroku(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}
	
	@AndroidFindBy(xpath="select#dropdown")
	WebElement dropdown;
	
	
	public String selectFromDropdown() throws InterruptedException
	{
		Select select=new Select(dropdown);
		Thread.sleep(2000);
		select.selectByVisibleText("Option 2");
		Thread.sleep(2000);
		return select.getFirstSelectedOption().getAttribute("value");
	}
}

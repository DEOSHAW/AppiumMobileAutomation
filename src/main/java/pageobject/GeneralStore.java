package pageobject;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GeneralStore 
{
	AndroidDriver driver;
	public GeneralStore(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	WebElement shopButton;
	
	@AndroidFindBy(id="android:id/content")
	WebElement screenWithScroll;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Nike SFB Jungle']")
	WebElement nikeProduct;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	WebElement addToCartButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	WebElement cartIcon;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	WebElement cartTitle;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	WebElement visitWebsiteLink;
	
	@FindBy(how=How.NAME,using="q")
	WebElement searchTextBox;
	
	
	@FindBy(xpath="//span[text()='Show more']")
	WebElement showMoreButton;
	
	
	public String navigateToProductsPage()
	{
		driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true))" +
			    ".scrollIntoView(new UiSelector().text(\"Australia\"))"
			)).click();
		
		nameField.sendKeys("Deo Shaw");
		shopButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		String title=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"))).getText();
		return title;
	}
	
	public String scrollToProduct() throws InterruptedException
	{
		//Scroll to the bottom of the screen
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("element", screenWithScroll); // Pass the WebElement itself
		params.put("direction", "down"); // or "up", "left", "right"
		params.put("percent", 1.0);
		for (int i = 0; i < 4; i++) {
	    ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params);
		    }
		Thread.sleep(3000);
		return nikeProduct.getText();
	}
	
	public String validateAddToCart()
	{
		addToCartButton.click();
		cartIcon.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"))).getText();
		
	}
	
	public String navigateToWebSite() throws InterruptedException
	{
		visitWebsiteLink.click();
		Thread.sleep(5000);
		Set<String> allContexts=driver.getContextHandles();
		for(String context: allContexts)
		{
			System.out.println(context);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		searchTextBox.sendKeys("Appium");
		searchTextBox.sendKeys(Keys.ENTER);
		return driver.getCurrentUrl();
		
	}

}

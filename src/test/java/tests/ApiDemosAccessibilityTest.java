package tests;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import pageobject.ApiDemosAccessibility;

public class ApiDemosAccessibilityTest extends Baseclass
{
	@Test
	void validateNavigationToNodeProvider() throws InterruptedException
	{
		driver.rotate(ScreenOrientation.LANDSCAPE);
		ApiDemosAccessibility ob=new ApiDemosAccessibility(driver);
		String infoText=ob.navigateToNodeProvider();
		Assert.assertEquals(infoText, "Enable TalkBack and Explore-by-touch from accessibility settings. Then touch the colored squares.");
	}
	
}

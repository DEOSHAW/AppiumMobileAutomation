package tests;
import java.util.List;

import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import pageobject.ApiDemosPreferences;

public class ApiDemosPreferencesTest extends Baseclass
{
	@Test
	void validateNavigationToNodeProvider() throws InterruptedException
	{
		ApiDemosPreferences ob=new ApiDemosPreferences(driver);
		List<String> allPreferences=ob.getPreferences();
		Assert.assertEquals(allPreferences.get(3), "4. Default values", "Text is not Default Values");
	}
}

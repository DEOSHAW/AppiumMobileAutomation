package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseclassBrowserStack;
import pageobject.ApiDemosGraphics;

public class ApiDemosGraphicsTest extends BaseclassBrowserStack
{
	@Test
	void validateNavigationToDrawable() throws InterruptedException
	{
		ApiDemosGraphics ob=new ApiDemosGraphics(driver);
		String labelText=ob.navigateToDrawableLink();
		Assert.assertEquals(labelText, "Drawable");
	}
}

package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseclassBrowserStack;
import pageobject.ApiDemosViews;

public class ApiDemosViewsTest extends BaseclassBrowserStack
{
	@Test
	void validateViews()
	{
		ApiDemosViews ob=new ApiDemosViews(driver);
		List<String> viewsList=ob.getViews();
		Assert.assertEquals(viewsList.get(3), "Buttons");
	}
}

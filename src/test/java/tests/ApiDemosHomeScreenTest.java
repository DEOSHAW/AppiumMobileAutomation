package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import pageobject.ApiDemosHomeScreen;

public class ApiDemosHomeScreenTest extends Baseclass
{
	@Test
	void validateOptionsOnHomePage()
	{
		List<String> allOptions=new ApiDemosHomeScreen(driver).getHomePageOptions();
		Assert.assertEquals(allOptions.get(3), "App");
	}

}

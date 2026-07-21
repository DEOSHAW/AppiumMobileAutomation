package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseclassBrowserStack;
import pageobject.ApiDemosMedia;

public class ApiDemosMediaTest extends BaseclassBrowserStack
{
	@Test
	void validateMediaFlow()
	{
		ApiDemosMedia ob=new ApiDemosMedia(driver);
		List<String> allMedia=ob.navigateMediaFlow();
		Assert.assertEquals(allMedia.get(1), "MediaPlayer");
	}
}

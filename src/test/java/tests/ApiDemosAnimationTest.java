package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import pageobject.ApiDemosAnimation;

public class ApiDemosAnimationTest extends Baseclass
{
	@Test
	void validateBouncingBallBackground()
	{
		
		ApiDemosAnimation ob =  new ApiDemosAnimation(driver);
		Assert.assertTrue(ob.isBouncingBallBackgroundPresent(), "Background is not present!");
	}

}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import pageobject.ApiDemosApp;

public class ApiDemosAppTest extends Baseclass
{
	
	@Test
	void validateActionList()
	{
		ApiDemosApp ob=new ApiDemosApp(driver);
		Assert.assertEquals(ob.getAllActions().get(3), "Action Provider");
	}

}

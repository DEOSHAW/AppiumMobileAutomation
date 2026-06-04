package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import pageobject.ApiDemosContent;

public class ApiDemosContentTest extends Baseclass
{
	@Test
	void getContentList()
	{
		ApiDemosContent ob=new ApiDemosContent(driver);
		List<String> allContent=ob.getAllContent();
		System.out.println(allContent);
		Assert.assertEquals(allContent.get(3), "Provider");
	}

}

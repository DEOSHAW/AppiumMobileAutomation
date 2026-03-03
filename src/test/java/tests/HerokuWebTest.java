package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseclassWeb;
import pageobject.Heroku;

public class HerokuWebTest extends BaseclassWeb
{
	@Test
	void validateSelectedDropdownValue() throws InterruptedException
	{
		driver.get("https://the-internet.herokuapp.com/dropdown");
		Heroku ob=new Heroku(driver);
		String selectedOption=ob.selectFromDropdown();
		Assert.assertEquals(selectedOption, "2");
	}
}

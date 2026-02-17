package tests;

import org.testng.annotations.Test;

import Base.BaseclassWeb;
import pageobject.Heroku;

public class HerokuWebTest extends BaseclassWeb
{
	@Test
	void validateSelectedDropdownValue()
	{
		driver.get("https://the-internet.herokuapp.com/dropdown");
		Heroku ob=new Heroku(driver);
		ob.selectFromDropdown();
	}
}

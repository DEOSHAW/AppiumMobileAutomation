package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseclassWeb;
import pageobject.Heroku;

public class HerokuFileUploadTest extends BaseclassWeb
{
	@Test
	void ValidateUploadFile() throws Exception
	{
		driver.get("https://the-internet.herokuapp.com/upload");
		Heroku ob=new Heroku(driver);
		String pageHeader=ob.navigateToFileUploadPage();
		Assert.assertEquals(pageHeader, "File Uploader");
	}
}

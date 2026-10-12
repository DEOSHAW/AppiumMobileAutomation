package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseclassBrowserStack;
import pageobject.ApiDemosWebView;

public class ApiDemosWebViewScrollTest extends BaseclassBrowserStack
{
	@Test
	void validateWebView()
	{
		ApiDemosWebView ob=new ApiDemosWebView(driver);
		String webViewlinkText=ob.navigateToWebView();
		Assert.assertEquals(webViewlinkText, "WebView");
	}

}

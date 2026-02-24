package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Baseclass {
	//protected static AppiumDriverLocalService service;
    protected static AndroidDriver driver;
	
	@BeforeMethod
	 public void LaunchApp() throws MalformedURLException
	 {
//		// Start Appium server on default port 4723
//        service = new AppiumServiceBuilder()
//                .withIPAddress("127.0.0.1")
//                .usingPort(4723)
//                .build();
//        service.start();
//
//        System.out.println("Appium Server Started at: " + service.getUrl());
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setApp("C:\\Selenium Projects\\General-Store.apk");
		options.setDeviceName("emulator-5554");
		options.setChromedriverExecutable(System.getProperty("user.dir")+File.separator+"chromedriver.exe");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	 }
	
	@AfterMethod
	public void CloseApp()
	{
		if (driver != null) {
            driver.quit();
            System.out.println("Android Driver Stopped");
        }
//        if (service != null) {
//            service.stop();
//            System.out.println("Appium Server Stopped");
//        }
	}
}

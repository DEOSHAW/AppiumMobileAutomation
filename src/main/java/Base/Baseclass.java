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
		//options.setApp(System.getProperty("user.dir")+File.separator+"Apps\\General-Store.apk");
		//options.setApp(System.getProperty("user.dir")+File.separator+"Apps\\ApiDemos-debug.apk");
		options.setDeviceName("emulator-5554");
		//For Real device (You may remove above step to set app if app is already installed and instead use app package and app activity
		//options.setDeviceName("192.168.29.149:45865");
		//options.setUdid("192.168.29.149:45865"); // needed to avoid conflict if multiple connected devices
		//options.setNoReset(true);
		options.setAppPackage("io.appium.android.apis");
		options.setAppActivity("io.appium.android.apis.ApiDemos");
		options.setCapability("uiautomator2ServerLaunchTimeout", 60000);
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

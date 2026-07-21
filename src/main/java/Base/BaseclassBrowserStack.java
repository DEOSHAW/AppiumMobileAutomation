package Base;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseclassBrowserStack {

    protected AndroidDriver driver;

    @BeforeMethod
    public void launchApp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        // ======================
        // Device configuration
        // ======================
        options.setPlatformName("Android");
        options.setDeviceName("Google Pixel 8");
        options.setPlatformVersion("14.0");

        // ======================
        // App URL (BrowserStack)
        // ======================
        options.setCapability("app", "bs://c3af7ce99f4facc66e542241ebcba43aae03c3ec");

        // ======================
        // BrowserStack Options
        // ======================
        HashMap<String, Object> bstackOptions = new HashMap<>();

        bstackOptions.put("userName", "deoshaw_jbyRKE");
        bstackOptions.put("accessKey", "8KznaoqY3otCYTqaT6Vf");

        bstackOptions.put("projectName", "App Testing");
        bstackOptions.put("buildName", "Regression");
        bstackOptions.put("sessionName", "Test Execution");

        // Debugging (important for visibility)
        bstackOptions.put("debug", true);
        bstackOptions.put("networkLogs", true);
        bstackOptions.put("appiumVersion", "2.0.0");

        // Attach to options
        options.setCapability("bstack:options", bstackOptions);

        // ======================
        // BrowserStack Hub
        // ======================
        driver = new AndroidDriver(
                new URL("https://hub-cloud.browserstack.com/wd/hub"),
                options
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Session ID: " + driver.getSessionId());
    }

    @AfterMethod
    public void closeApp() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Driver session closed");
    }
}
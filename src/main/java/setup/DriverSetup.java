package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static entities.OptionsKeys.*;
import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class DriverSetup {

    protected static AppiumDriver driver;
    protected static WebDriverWait wait;

    protected static String DEVICE;
    protected static String TEST_PLATFORM;
    protected static String AUT;
    public static String APP_PATH;
    protected static String DRIVER;
    //
    public static String DRIVER_PATH;
    //
    public static String BROWSER_TITLE;
    public static String SUT;

    private DriverSetup() {
    }

    public static void setProperties(TestProperties properties) throws IOException {
        DEVICE = properties.getProp(DEVICE_KEY.key);
        TEST_PLATFORM = properties.getProp(PLATFORM_KEY.key);
        AUT = properties.getProp(AUT_KEY.key);
        APP_PATH = properties.getProp(APP_PATH_KEY.key);
        DRIVER = properties.getProp(DRIVER_KEY.key);
        //
        DRIVER_PATH = properties.getProp(DRIVER_PATH_KEY.key);
        //
        BROWSER_TITLE = properties.getProp(BROWSER_KEY.key);
        String t_sut = properties.getProp(SUT_KEY.key);
        SUT = t_sut == null ? null : "http://" + t_sut;
    }

    public static void prepareDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browserName;

        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(DEVICE_NAME, DEVICE);
                browserName = "Chrome";
                //
                capabilities.setCapability("chromedriverExecutable",
                        new File(DRIVER_PATH).getAbsolutePath());
                //
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default:
                throw new IllegalArgumentException("Unknown mobile platform: " + TEST_PLATFORM);
        }

        capabilities.setCapability(PLATFORM_NAME, TEST_PLATFORM);

        if (AUT != null && SUT == null) {
            capabilities.setCapability(APP, new File(AUT).getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(BROWSER_NAME, browserName);
        } else {
            throw new IllegalArgumentException("Unknown momile apps type.");
        }

        driver = new AppiumDriver(new URL(DRIVER), capabilities);
        wait = new WebDriverWait(driver, 10);
    }

    public static AppiumDriver driver() throws MalformedURLException {
        if (driver == null) prepareDriver();
        return driver;
    }

    public static WebDriverWait waits() throws MalformedURLException {
        if (wait == null) prepareDriver();
        return wait;
    }

   /* protected void prepareNative() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", DEVICE);
        capabilities.setCapability("platformName", TEST_PLATFORM);

        File app = new File(AUT);
        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new AndroidDriver(new URL(DRIVER), capabilities);
    }

    protected void prepareAndroidWeb() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", DEVICE);
        capabilities.setCapability("platformName", TEST_PLATFORM);
        capabilities.setCapability("browserName", BROWSER);
        capabilities.setCapability("chromedriverExecutable", BROWSER_PATH);

        driver = new AndroidDriver(new URL(DRIVER), capabilities);
    }*/

}



























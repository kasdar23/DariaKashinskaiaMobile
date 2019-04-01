package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static entities.OptionsKeys.*;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class DriverSetup {

    protected static AppiumDriver driver;
    protected static WebDriverWait wait;

    protected static String DEVICE;
    protected static String DEVICE_UDID;
    protected static String TEST_PLATFORM;
    protected static String AUT;
    public static String APP_PAKAGES;
    protected static String APP_ACTIVITYS;
    protected static String DRIVER;
    public static String BROWSER_TITLE;
    public static String SUT;

    private DriverSetup() {
    }

    public static void setProperties(TestProperties properties) throws IOException {
        DEVICE = properties.getProp(DEVICE_KEY.key);
        DEVICE_UDID = properties.getProp(DEVICE_UDID_KEY.key);
        TEST_PLATFORM = properties.getProp(PLATFORM_KEY.key);
        AUT = properties.getProp(AUT_KEY.key);
        APP_PAKAGES = properties.getProp(APP_PACKAGE_KEY.key);
        APP_ACTIVITYS = properties.getProp(ADD_ACTIVITY_KEY.key);
        DRIVER = properties.getProp(DRIVER_KEY.key);
        BROWSER_TITLE = properties.getProp(BROWSER_KEY.key);
        String t_sut = properties.getProp(SUT_KEY.key);
        SUT = t_sut == null ? null : "http://" + t_sut;
    }

    public static void prepareDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browserName;

        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(UDID, DEVICE_UDID);
                browserName = "Chrome";
                break;
            case "iOS":
                capabilities.setCapability(UDID, DEVICE_UDID);
                browserName = "Safari";
                break;
            default:
                throw new IllegalArgumentException("Unknown mobile platform: " + TEST_PLATFORM);
        }

        capabilities.setCapability(PLATFORM_NAME, TEST_PLATFORM);

        if (AUT != null && SUT == null) {
            capabilities.setCapability(UDID, DEVICE_UDID);
            capabilities.setCapability(APP_PACKAGE, APP_PAKAGES);
            capabilities.setCapability(APP_ACTIVITY, APP_ACTIVITYS);
            capabilities.setCapability("autoLaunch", false);
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

}



























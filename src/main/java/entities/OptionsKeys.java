package entities;

public enum OptionsKeys {

    DEVICE_KEY("device"),
    PLATFORM_KEY("platform"),
    AUT_KEY("aut"),
    APP_PATH_KEY("appPathInDevice"),
    DRIVER_KEY("driver"),
    DRIVER_PATH_KEY("driverPath"),
    BROWSER_KEY("browser"),
    SUT_KEY("sut"),
    TITLE("Internet Assigned Numbers Authority");

    public String key;

    OptionsKeys(String key) {
        this.key = key;
    }
}

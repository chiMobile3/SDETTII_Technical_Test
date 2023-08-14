package driver;

import io.appium.java_client.android.AndroidDriver;


public class PageDriver {
    private static final ThreadLocal<AndroidDriver> androiddriver = new ThreadLocal<>();
    private static PageDriver instance = null;

    private PageDriver() {
        //empty
    }

    //create instance
    public static PageDriver getInstance() {
        if (instance == null) {
            instance = new PageDriver();
        }
        return instance;
    }

    //set driver
    public void setAndroiddriver(AndroidDriver driver) {
        androiddriver.set(driver);
    }

    //get
    public AndroidDriver getDriver() {
        return androiddriver.get();
    }

    // Get current driver
    public static AndroidDriver getCurrentDriver() {
        return getInstance().getDriver();
    }
}


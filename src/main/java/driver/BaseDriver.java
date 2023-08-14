package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.Dataparser;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseDriver {

    public static AndroidDriver driver;
    Properties prop = Dataparser.loadProperties("devices.properties");

    public AndroidDriver setup(String platform_name, String device_version, String device_name, String udid) {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform_name);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, device_version);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
        cap.setCapability(MobileCapabilityType.UDID, udid);

//cap.setCapability("appPackage","com.nopstation.nopcommerece.nopstationcart");
//cap.setCapability("appActivity","com.bs.ecommerece.main.MainActivity");

        //APK file path
        File appDir = new File("src/main/resources");
        File app = new File(appDir, "nopstationCart_4.40.apk");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        // Appium server
        URL url = null;
        try {
            url = new URL("http://0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        assert url != null;

        driver = new AndroidDriver(url, cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //PageDriver setup
        PageDriver.getInstance().setAndroiddriver(driver);
        return driver;

    }


}

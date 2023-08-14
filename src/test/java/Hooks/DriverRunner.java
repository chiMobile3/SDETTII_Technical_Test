package Hooks;

import driver.BaseDriver;
import driver.PageDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import utilities.Dataparser;

import java.util.Properties;

public class DriverRunner extends BaseDriver {
    Properties prop = Dataparser.loadProperties("devices.properties");

    @Before

    public void startDriver() {
        String pname, dversion, dname, id;
        pname = prop.getProperty("platform_name");
        dversion = prop.getProperty("device_version");
        dname = prop.getProperty("device_name");
        id = prop.getProperty("udid");
        driver = setup(pname, dversion, dname, id);
    }

    @After
    public void closeDriver() {
        PageDriver.getCurrentDriver().quit();
    }
}

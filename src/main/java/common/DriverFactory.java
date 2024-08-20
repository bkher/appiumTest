package common;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static AppiumDriver getDriver(String platform, Properties config) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", config.getProperty("deviceName"));
        capabilities.setCapability("udid", config.getProperty("udid"));
        capabilities.setCapability("platformName", platform);

        if (platform.equalsIgnoreCase("Android")) {
            capabilities.setCapability("systemPort", config.getProperty("systemPort"));
            capabilities.setCapability("appPackage", config.getProperty("appPackage"));
            capabilities.setCapability("appActivity", config.getProperty("appActivity"));
            driver.set(new AndroidDriver(new URL(config.getProperty("appiumServerURL")), capabilities));
        } else if (platform.equalsIgnoreCase("iOS")) {
            capabilities.setCapability("wdaLocalPort", config.getProperty("wdaLocalPort"));
            capabilities.setCapability("bundleId", config.getProperty("bundleId"));
            driver.set(new IOSDriver(new URL(config.getProperty("appiumServerURL")), capabilities));
        }

        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

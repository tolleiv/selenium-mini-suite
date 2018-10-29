package de.tolleiv.aoe2018.selenium;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class BaseTest {
    public static final String URL = "http://zalenium.congstar-congo.aoe.host/wd/hub";

    static WebDriver getWebDriver(String name) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "firefox");
        caps.setCapability("zal:name", name + " " + UUID.randomUUID().toString());
        caps.setCapability("zal:build", System.getenv("BUILD_TAG"));

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            Assert.fail();
        }
        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        System.out.println(capabilities.getCapability("zal:name"));
        return driver;
    }
}

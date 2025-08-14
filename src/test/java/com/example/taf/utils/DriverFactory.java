package com.example.taf.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (TL_DRIVER.get() == null) {
            String browser = ConfigLoader.get("browser");
            boolean headless = Boolean.parseBoolean(ConfigLoader.get("headless"));
            boolean remote = Boolean.parseBoolean(System.getenv().getOrDefault("SELENIUM_REMOTE", "false"));

            if ("chrome".equalsIgnoreCase(browser)) {
                ChromeOptions options = new ChromeOptions();
                if (headless) options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                TL_DRIVER.set(buildDriver(remote, options));
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            TL_DRIVER.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigLoader.get("implicitWait"))));
        }
        return TL_DRIVER.get();
    }

    private static WebDriver buildDriver(boolean remote, MutableCapabilities caps) {
        if (remote) {
            try {
                return new RemoteWebDriver(new URL(ConfigLoader.get("gridUrl")), caps);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver((ChromeOptions)caps);
        }
    }

    public static void quitDriver() {
        WebDriver d = TL_DRIVER.get();
        if (d != null) {
            d.quit();
            TL_DRIVER.remove();
        }
    }
}

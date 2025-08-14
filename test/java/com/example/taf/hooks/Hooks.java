package com.example.taf.hooks;

import com.example.taf.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before("@ui")
    public void beforeUI() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
    }

    @After("@ui")
    public void afterUI() {
        DriverFactory.quitDriver();
    }
}

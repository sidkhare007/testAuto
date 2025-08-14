package com.example.taf.pages;

import com.example.taf.utils.ConfigLoader;
import com.example.taf.utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver = DriverFactory.getDriver();
    protected String baseUrl = ConfigLoader.get("baseUrl");
}

package com.example.taf.pages;

public class HomePage extends BasePage {
    public void open() {
        driver.get(baseUrl);
    }
    public String getTitle() {
        return driver.getTitle();
    }
}

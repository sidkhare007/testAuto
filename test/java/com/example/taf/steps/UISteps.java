package com.example.taf.steps;

import com.example.taf.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class UISteps {

    private final HomePage home = new HomePage();

    @Given("I open the home page")
    public void i_open_the_home_page() {
        home.open();
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expected) {
        String title = home.getTitle();
        Assertions.assertTrue(title.contains(expected), "Expected title to contain: " + expected + " but was: " + title);
    }
}

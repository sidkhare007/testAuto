package com.example.taf.steps;

import com.example.taf.utils.APIClient;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class APISteps {

    private Response response;

    @When("I GET {string}")
    public void i_get(String path) {
        response = APIClient.get(path);
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer code) {
        Assertions.assertEquals(code.intValue(), response.getStatusCode());
    }

    @Then("the JSON path {string} should be {int}")
    public void the_json_path_should_be(String jsonPath, Integer value) {
        Integer actual = response.jsonPath().getInt(jsonPath);
        Assertions.assertEquals(value, actual);
    }
}

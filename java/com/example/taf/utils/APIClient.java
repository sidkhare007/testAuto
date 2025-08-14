package com.example.taf.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIClient {

    public static Response get(String path) {
        String base = ConfigLoader.get("apiBase");
        return RestAssured.given().baseUri(base).when().get(path).then().extract().response();
    }
}

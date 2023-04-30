package com.tc.base;

import java.util.Map;

import com.tc.constants.API_Endpoints;
import com.tc.enums.HTTPMethod;
import com.tc.extentReport.ExtentLogger;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    private static RequestSpecBuilder requestSpecBuilder;

    public void buildService() {
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(API_Endpoints.BASE_URI);
        requestSpecBuilder.setContentType("application/json");
        requestSpecBuilder.setAccept("application/json");

        ExtentLogger.logMessage("STEP : Setting Up Prerequisite!");
    }
    public void setHeader(Map<String, String> cookies) {
        requestSpecBuilder.addHeaders(cookies);

        ExtentLogger.logMessage("STEP : Auth Token Setup");
    }

    public void setBody(Object requestBody) {
        ExtentLogger.logRequestBody(requestBody);
        ExtentLogger.logMessage("STEP : Request Body Setup in API Request");

        requestSpecBuilder.setBody(requestBody);
    }

    public Response executeAPI(HTTPMethod httpMethod, String endpoint) {
        Response response = null;
        ExtentLogger.logMessage("STEP : " + httpMethod + " will execute at " + endpoint);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.spec(requestSpecBuilder.build());
        switch (httpMethod) {
            case GET:
                response = requestSpecification.when().get(endpoint).then().extract().response();
                break;
            case PUT:
                response = requestSpecification.when().put(endpoint).then().extract().response();
                break;
            case DELETE:
                response = requestSpecification.when().delete(endpoint).then().extract().response();
                break;
            case POST:
                response = requestSpecification.when().post(endpoint).then().extract().response();
                break;
        }
        ExtentLogger.logResponseBody(response.asPrettyString());

        return response;
    }
}

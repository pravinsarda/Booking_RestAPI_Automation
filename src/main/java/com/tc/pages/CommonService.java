package com.tc.pages;

import com.tc.base.BaseService;
import com.tc.constants.API_Endpoints;
import com.tc.enums.HTTPMethod;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


public class CommonService extends BaseService {

    public String getAccessToken(){
       buildService();
       String payload = "{\n" +
               "    \"username\" : \"admin\",\n" +
               "    \"password\" : \"password123\"\n" +
               "}";
//       return given().baseUri(API_Endpoints.BASE_URI).contentType(ContentType.JSON).body(payload).post(API_Endpoints.AUTH).jsonPath().getString("token");
       setBody(payload);
       return executeAPI(HTTPMethod.POST, API_Endpoints.AUTH).jsonPath().getString("token");
    }

}

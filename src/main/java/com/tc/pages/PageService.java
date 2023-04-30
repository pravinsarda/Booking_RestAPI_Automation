package com.tc.pages;

import com.tc.constants.API_Endpoints;
import com.tc.enums.HTTPMethod;
import com.tc.requestBody.Bookingdates;
import com.tc.requestBody.CreatBookingRequest;
import com.tc.utils.TestData;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class PageService extends CommonService {

    TestData testData = new TestData();

    public Response createBooking(){
        CreatBookingRequest creatBookingRequest = CreatBookingRequest.builder()
                .firstname(testData.getFirstName())
                .lastname(testData.getLastName())
                .totalprice(120)
                .depositpaid(true)
                .additionalneeds("Breakfast")
                .bookingdates(Bookingdates.builder().checkin(testData.getDate()).checkout(testData.getDate()).build())
                .build();
        setBody(creatBookingRequest);
        return executeAPI(HTTPMethod.POST, API_Endpoints.CREATE_BOOKING);
    }

    public Response getBookingId(int id){
        return executeAPI(HTTPMethod.GET, String.format(API_Endpoints.GET_BOOKING, id));
    }

    public Response updateBookingDetails(int id,CreatBookingRequest creatBookingRequest ){
        setTokenInCookies();
        setBody(creatBookingRequest);
        return executeAPI(HTTPMethod.PUT, String.format(API_Endpoints.UPDATE_BOOKING, id));
    }

    public Response deleteBookingId(int id){
        setTokenInCookies();
        return executeAPI(HTTPMethod.DELETE, String.format(API_Endpoints.DELETE_BOOKING, id));
    }

    private void setTokenInCookies() {
        Map<String, String> cookies = new HashMap<>();
        cookies.put("Cookie","token="+getAccessToken());
        setHeader(cookies);
    }

}

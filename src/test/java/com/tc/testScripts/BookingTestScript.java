package com.tc.testScripts;

import com.tc.constants.StatusCode;
import com.tc.listeners.TestCaseListener;
import com.tc.pages.PageService;
import com.tc.requestBody.Bookingdates;
import com.tc.requestBody.CreatBookingRequest;
import com.tc.utils.TestData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestCaseListener.class)
public class BookingTestScript {

	PageService pageService = new PageService();
	TestData testData = new TestData();


	@Test
	public void createBookingTest(){
		Response response = pageService.createBooking();
		Assert.assertEquals(response.getStatusCode(), StatusCode.OK);
	}

	@Test
	public void getBookingIdTest(){
		Response response = pageService.createBooking();
		Assert.assertEquals(response.getStatusCode(), StatusCode.OK);
		int bookingID = response.jsonPath().getInt("bookingid");
		Response getBookingResponse = pageService.getBookingId(bookingID);

		Assert.assertEquals(getBookingResponse.getStatusCode(), StatusCode.OK);
	}

	@Test
	public void udpateBookingTest(){
		Response response = pageService.createBooking();
		Assert.assertEquals(response.getStatusCode(), StatusCode.OK);
		int bookingID = response.jsonPath().getInt("bookingid");
		CreatBookingRequest creatBookingRequest = CreatBookingRequest.builder()
				.firstname(testData.getFirstName())
				.lastname(testData.getLastName())
				.totalprice(130)
				.depositpaid(false)
				.additionalneeds("Dinner")
				.bookingdates(Bookingdates.builder().checkin(testData.getDate()).checkout(testData.getDate()).build())
				.build();
		Response udpatedBookingResponse = pageService.updateBookingDetails(bookingID, creatBookingRequest);

		Assert.assertEquals(udpatedBookingResponse.getStatusCode(), StatusCode.OK);
	}

	@Test
	public void deleteBookingTest(){
		Response response = pageService.createBooking();
		Assert.assertEquals(response.getStatusCode(), StatusCode.OK);
		int bookingID = response.jsonPath().getInt("bookingid");
		Response deleteBookingResponse = pageService.deleteBookingId(bookingID);

		Assert.assertEquals(deleteBookingResponse.getStatusCode(), StatusCode.CREATED);
	}
}

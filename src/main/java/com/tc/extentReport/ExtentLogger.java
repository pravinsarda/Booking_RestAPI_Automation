package com.tc.extentReport;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentLogger {

	public static void logRequestBody(Object object) {
		ExtentManager.getCurrentTest().log(Status.PASS, MarkupHelper.createJsonCodeBlock(object));
	}

	public static void logResponseBody(String response) {
		ExtentManager.getCurrentTest().log(Status.PASS, MarkupHelper.createCodeBlock("Response", response));
	}

	public static void logMessage(String logMessage) {
		ExtentManager.getCurrentTest().log(Status.PASS, MarkupHelper.createLabel(logMessage, ExtentColor.GREEN));
	}

}

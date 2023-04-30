package com.tc.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tc.base.BaseService;
import com.tc.extentReport.ExtentManager;

public class TestCaseListener extends BaseService implements ITestListener {

	public void onTestStart(ITestResult result) {
		ExtentManager.createTestCase(result);
		buildService();
	}

	public void onTestSuccess(ITestResult result) {
		ExtentManager.testSuccess(result);
	}

	public void onTestFailure(ITestResult result) {
		ExtentManager.testFail(result);
	}

	public void onTestSkipped(ITestResult result) {
		ExtentManager.testSkip(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		ExtentManager.initExtentReports();
	}

	public void onFinish(ITestContext context) {
		ExtentManager.flushReport();
	}

}

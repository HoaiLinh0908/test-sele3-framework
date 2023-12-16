package com.test.listener;

import com.aventstack.extentreports.Status;
import com.senelium.reports.AllureManager;
import com.test.report.ExtentReportManager;
import com.test.report.ExtentTestManager;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestListener implements ITestListener {
    @Override
    public void onStart(ITestContext result) {
        System.out.println("======START======");
        System.out.println("Start " + result.getName());
    }

    @Override
    public void onFinish(ITestContext result) {
        System.out.println("Ending testing: " + result.getName());
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Start test case: " + result.getName());
        ExtentTestManager.saveToReport(result.getName(), "Descriptions Here");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case : " + result.getName() + " is success");
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case : " + result.getName() + " is failed");

        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");

        AllureManager.saveScreenshotPNG();
        AllureManager.saveTextLog("Test case : " + result.getName() + " is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case : " + result.getName() + " is skipped");
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }
}

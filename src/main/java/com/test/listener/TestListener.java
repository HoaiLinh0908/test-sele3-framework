package com.test.listener;

import com.senelium.Senelium;
import com.test.report.AllureManager;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Start test case: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case : " + result.getName() + " is success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case : " + result.getName() + " is failed");
        saveTextLog(result.getName() + " is failed1.");
        saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case : " + result.getName() + " is skipped");
    }

    @Attachment(value = "{0}", type = "text/plain")
    public String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        System.out.println("taking screenshot");
        TakesScreenshot screenshot = (TakesScreenshot) Senelium.getSeneDriver().getDriver();

        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

}

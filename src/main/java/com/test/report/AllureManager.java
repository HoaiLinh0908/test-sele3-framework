package com.test.report;

import com.senelium.Senelium;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureManager {

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG() {
        System.out.println("taking screenshot");
        return ((TakesScreenshot) Senelium.getSeneDriver().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
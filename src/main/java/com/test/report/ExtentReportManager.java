package com.test.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/extent-report/extent-report.html");
        reporter.config().setReportName("Extent Report | Linh Do");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Senelium 3 | Linh Do");
        extentReports.setSystemInfo("Author", "Linh Do");
        return extentReports;
    }
}

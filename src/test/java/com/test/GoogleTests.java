package com.test;

import com.senelium.Senelium;
import com.senelium.config.DriverConfig;
import com.senelium.config.Timeout;
import com.senelium.driver.factory.ChromeDriverFactory;
import com.senelium.driver.factory.DriverFactory;
import com.senelium.element.Element;
import com.test.listener.TestListener;
import com.test.pages.GooglePage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(TestListener.class)
public class GoogleTests {
    GooglePage googlePage = new GooglePage();
    DriverConfig configuration;
    DriverFactory factory;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        ChromeOptions chrome = new ChromeOptions();
        //Chrome config
        configuration = new DriverConfig(chrome, "", false, Timeout.getDefault());
        factory = new ChromeDriverFactory();
        Senelium.createDriver(configuration, factory);
        Senelium.open("https://www.google.com");
    }

    @Test(description = "Test Google")
    void googleTest() {
        googlePage.search("Christmas");
    }

    @Test(description = "Failed Test")
    void failedTest() {
        Assert.assertTrue(!googlePage.isSearchBarDisplayed(), "This test failed");
    }

    @Test(description = "Skipped Test")
    void skippedTest() {
        throw new SkipException("Skip this test!");
    }

    @AfterClass
    void afterClass() {
        Senelium.sleep(Duration.ofSeconds(2));
        Senelium.closeBrowser();
    }
}

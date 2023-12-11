package com.test;

import com.senelium.Senelium;
import com.senelium.config.DriverConfig;
import com.senelium.config.Timeout;
import com.senelium.driver.factory.ChromeDriverFactory;
import com.senelium.driver.factory.DriverFactory;
import com.senelium.element.Element;
import com.test.listener.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(TestListener.class)
public class YoutubeTests {
    DriverConfig configuration;
    DriverFactory factory;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        ChromeOptions chrome = new ChromeOptions();
        configuration = new DriverConfig(chrome, "", false, Timeout.getDefault());
        factory = new ChromeDriverFactory();
    }

    @Test
    void youtubeTest() {
        Senelium.createDriver(configuration, factory);
        Senelium.open("https://www.youtube.com");
        Element search = new Element(By.cssSelector("input#search"));
        search.type("Christmas");
        Senelium.sleep(Duration.ofSeconds(3));
        Senelium.closeBrowser();
    }
}

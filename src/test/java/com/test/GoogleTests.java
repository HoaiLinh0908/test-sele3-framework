package com.test;

import com.senelium.Senelium;
import com.senelium.config.DriverConfig;
import com.senelium.config.Timeout;
import com.senelium.driver.factory.ChromeDriverFactory;
import com.senelium.driver.factory.DriverFactory;
import com.senelium.element.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTests {
    DriverConfig configuration;
    DriverFactory factory;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        ChromeOptions chrome = new ChromeOptions();
        //Chrome config
        configuration = new DriverConfig(chrome, "", false, Timeout.getDefault());
        factory = new ChromeDriverFactory();
    }

    @Test
    void googleTest() {
        Senelium.createDriver(configuration, factory);
        Senelium.open("https://www.google.com");
        Element search = new Element(By.cssSelector("textarea[type='search']"));
        search.type("Christmas");
        System.out.println(search.isTag("textarea"));
        Senelium.sleep(Duration.ofSeconds(3));
        Senelium.closeBrowser();
    }
}

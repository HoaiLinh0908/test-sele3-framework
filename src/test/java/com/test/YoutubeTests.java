package com.test;

import com.senelium.Senelium;
import com.senelium.element.Element;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class YoutubeTests extends TestBase {

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        Senelium.open("https://www.youtube.com");
    }

    @Test
    void youtubeTest() {
        Element search = new Element(By.cssSelector("input#search"));
        search.type("Christmas");
        Senelium.sleep(Duration.ofSeconds(3));
        Senelium.closeBrowser();
    }
}

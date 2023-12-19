package com.test;

import com.senelium.Senelium;
import com.senelium.config.DriverConfig;
import com.senelium.config.Timeout;
import com.senelium.driver.factory.ChromeDriverFactory;
import com.senelium.driver.factory.DriverFactory;
import com.test.listener.TestListener;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class TestBase {

    @BeforeClass(alwaysRun = true)
    void initialTest() {
        ChromeOptions chrome = new ChromeOptions();
        //Chrome config
        DriverConfig configuration = new DriverConfig(chrome, "", false, Timeout.getDefault());
        DriverFactory factory = new ChromeDriverFactory();
        Senelium.createDriver(configuration, factory);
    }
}

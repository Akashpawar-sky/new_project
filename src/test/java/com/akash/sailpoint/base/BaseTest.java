package com.akash.sailpoint.base;

import com.akash.sailpoint.config.ConfigReader;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        if (ConfigReader.getBoolean("headless")) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--window-size=1440,1000");
        options.addArguments("--disable-notifications");

        // Selenium Manager (included with Selenium 4) resolves the compatible driver.
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getInt("explicitWaitSeconds"))
        );
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}

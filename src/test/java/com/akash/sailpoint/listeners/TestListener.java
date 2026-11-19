package com.akash.sailpoint.listeners;

import com.akash.sailpoint.base.BaseTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASS: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAIL: " + result.getMethod().getMethodName());
        Object testInstance = result.getInstance();

        if (testInstance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testInstance).getDriver();
            if (driver != null) {
                saveScreenshot(driver, result.getMethod().getMethodName());
            }
        }
    }

    private void saveScreenshot(WebDriver driver, String testName) {
        try {
            Path screenshotDirectory = Paths.get("target", "screenshots");
            Files.createDirectories(screenshotDirectory);

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path destination = screenshotDirectory.resolve(testName + "_" + timestamp + ".png");

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), destination);
            System.out.println("Failure screenshot: " + destination.toAbsolutePath());
        } catch (IOException | RuntimeException exception) {
            System.err.println("Could not save failure screenshot: " + exception.getMessage());
        }
    }
}

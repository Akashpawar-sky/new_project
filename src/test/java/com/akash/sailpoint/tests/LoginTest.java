package com.akash.sailpoint.tests;

import com.akash.sailpoint.base.BaseTest;
import com.akash.sailpoint.config.ConfigReader;
import com.akash.sailpoint.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify that a valid user can sign in")
    public void validUserCanLogin() {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        Assert.assertTrue(
                loginPage.isInventoryDisplayed(),
                "Inventory page should be visible after a successful login."
        );
    }
}

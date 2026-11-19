package com.akash.sailpoint.tests;

import com.akash.sailpoint.base.BaseTest;
import com.akash.sailpoint.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test(description = "Verify that an invalid password is rejected")
    public void invalidPasswordShowsError() {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.login("standard_user", "wrong_password");

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Username and password do not match"),
                "A clear login error should be displayed for invalid credentials."
        );
    }
}

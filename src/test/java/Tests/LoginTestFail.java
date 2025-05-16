package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Utils.BaseTest;

public class LoginTestFail extends BaseTest {
    @Test
    public void LoginTestFail() {
        test.info("Testing login with invalid credentials");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "invalid_pass");

        test.info("Login attempted with invalid credentials");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid login");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");
    }
}


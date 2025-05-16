package Tests;

import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        test.info("Navigating to SauceDemo login page");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        test.info("Login submitted, verifying result");

        Assert.assertTrue(loginPage.isLoginSuccessful(), "User should be on inventory page after valid login");
    }
}


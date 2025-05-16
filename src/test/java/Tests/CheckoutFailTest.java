package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Utils.BaseTest;

public class CheckoutFailTest extends BaseTest {

    @Test
    public void failCheckoutWithoutFirstName() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add a product
        CartPage cartPage = new CartPage(driver);
        cartPage.addFirstProductToCart();

        // Go to cart and checkout
        cartPage.openCart();
        cartPage.clickCheckout();

        // Fill only last name and postal code
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInformation("", "Doe", "12345");
        checkoutPage.clickContinue();

        // Verify error message
        String expectedError = "Error: First Name is required";
        Assert.assertEquals(checkoutPage.getErrorMessage(), expectedError, "Error message mismatch");
    }
}

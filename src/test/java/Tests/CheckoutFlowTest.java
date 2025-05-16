package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Utils.BaseTest;

public class CheckoutFlowTest extends BaseTest {

    @Test
    public void completeCheckoutFlow() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add product to cart
        CartPage cartPage = new CartPage(driver);
        cartPage.addFirstProductToCart();

        // Open cart and proceed to checkout
        cartPage.openCart();
        cartPage.clickCheckout();

        // Fill in checkout info
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInformation("John", "Doe", "12345");
        checkoutPage.clickContinue();

        // Verify overview page
        Assert.assertEquals(checkoutPage.getOverviewTitle(), "Checkout: Overview");

        // Finish checkout
        checkoutPage.clickFinish();

        // Verify confirmation
        Assert.assertEquals(checkoutPage.getConfirmationMessage(), "Thank you for your order!");
    }
}


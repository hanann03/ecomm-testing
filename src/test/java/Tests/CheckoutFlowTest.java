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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        CartPage cartPage = new CartPage(driver);
        cartPage.addFirstProductToCart();

        cartPage.openCart();
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInformation("John", "Doe", "12345");
        checkoutPage.clickContinue();

        Assert.assertEquals(checkoutPage.getOverviewTitle(), "Checkout: Overview");

        checkoutPage.clickFinish();

        Assert.assertEquals(checkoutPage.getConfirmationMessage(), "Thank you for your order!");
    }
}


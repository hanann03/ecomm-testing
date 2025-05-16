package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.CartPage;
import Utils.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void addAndRemoveProductFromCart() {
        // Login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        CartPage cartPage = new CartPage(driver);

        // Initially cart should be empty
        Assert.assertEquals(cartPage.getCartBadgeCount(), 0, "Cart should be empty initially");

        // Add first product to cart
        cartPage.addFirstProductToCart();
        test.info("Added first product to cart");

        // Verify cart badge updates to 1
        Assert.assertEquals(cartPage.getCartBadgeCount(), 1, "Cart badge should show 1 item");

        // Remove the product from cart
        cartPage.removeFirstProductFromCart();
        test.info("Removed first product from cart");

        // Verify cart badge is removed or 0
        Assert.assertEquals(cartPage.getCartBadgeCount(), 0, "Cart badge should be empty after removal");
    }
}


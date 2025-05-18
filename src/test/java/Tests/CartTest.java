package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.CartPage;
import Utils.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void addAndRemoveProductFromCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getCartBadgeCount(), 0, "Cart should be empty initially");

        cartPage.addFirstProductToCart();
        test.info("Added first product to cart");

        Assert.assertEquals(cartPage.getCartBadgeCount(), 1, "Cart badge should show 1 item");

        cartPage.removeFirstProductFromCart();
        test.info("Removed first product from cart");

        Assert.assertEquals(cartPage.getCartBadgeCount(), 0, "Cart badge should be empty after removal");
    }
}


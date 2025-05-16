package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By firstAddToCartButton = By.cssSelector("button[id^='add-to-cart']");
    private By firstRemoveButton = By.cssSelector("button[id^='remove']");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartIcon = By.className("shopping_cart_link");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstProductToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    public void removeFirstProductFromCart() {
        driver.findElement(firstRemoveButton).click();
    }

    public int getCartBadgeCount() {
        if (driver.findElements(cartBadge).isEmpty()) {
            return 0;
        }
        String countText = driver.findElement(cartBadge).getText();
        return Integer.parseInt(countText);
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}

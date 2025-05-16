package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    private By searchInput = By.id("small-searchterms");
    private By searchButton = By.cssSelector("input[type='submit'][value='Search']");
    private By productTitles = By.cssSelector(".product-title a");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String keyword) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public boolean anyResultContains(String keyword) {
        List<WebElement> titles = driver.findElements(productTitles);
        for (WebElement title : titles) {
            if (title.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchInput = By.id("small-searchterms");
    private By searchButton = By.cssSelector("input[type='submit'][value='Search']");
    private By productTitles = By.cssSelector(".product-title a");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchFor(String keyword) {
        WebElement searchInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        searchInputElement.clear();
        searchInputElement.sendKeys(keyword);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean anyResultContains(String keyword) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productTitles));
        List<WebElement> titles = driver.findElements(productTitles);
        for (WebElement title : titles) {
            if (title.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}

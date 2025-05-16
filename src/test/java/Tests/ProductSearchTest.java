package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.SearchPage;
import Utils.BaseTest;

import java.util.List;

public class ProductSearchTest extends BaseTest {

    @Test
    public void searchProductTest() {
        driver.get("https://demowebshop.tricentis.com");

        SearchPage searchPage = new SearchPage(driver);
        String keyword = "laptop";

        test.info("Searching for: " + keyword);
        searchPage.searchFor(keyword);

        Assert.assertTrue(searchPage.anyResultContains(keyword), "At least one result should contain the keyword: " + keyword);

    }
}

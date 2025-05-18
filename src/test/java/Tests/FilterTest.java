package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.FilterPage;
import Pages.LoginPage;
import Utils.BaseTest;

public class FilterTest extends BaseTest {

    @Test
    public void verifySortByPriceLowToHigh() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        FilterPage filterPage = new FilterPage(driver);
        filterPage.sortByLowToHigh();

        Assert.assertEquals(
                filterPage.getSelectedSortOption(),
                "Price (low to high)",
                "Selected filter should be 'Price (low to high)'"
        );
    }
}

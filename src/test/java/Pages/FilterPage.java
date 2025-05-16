package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FilterPage {
    private WebDriver driver;
    private By sortDropdown = By.className("product_sort_container");

    public FilterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortByLowToHigh() {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        dropdown.selectByVisibleText("Price (low to high)");
    }

    public String getSelectedSortOption() {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        return dropdown.getFirstSelectedOption().getText();
    }
}

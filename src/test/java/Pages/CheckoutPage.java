package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    private By overviewTitle = By.className("title");
    private By confirmationMessage = By.className("complete-header");
    private By errorMessage = By.cssSelector("h3[data-test='error']");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput)).sendKeys(firstName);
        wait.until(ExpectedConditions.elementToBeClickable(lastNameInput)).sendKeys(lastName);
        wait.until(ExpectedConditions.elementToBeClickable(postalCodeInput)).sendKeys(postalCode);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    public String getOverviewTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(overviewTitle)).getText();
    }

    public String getConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

}

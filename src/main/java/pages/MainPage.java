package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(shoppingListButton));
    }


    @FindBy(css = "[data-testid=\"shopping-list-nav-link\"")
    private WebElement shoppingListButton;

    @FindBy(css = "[data-testid=\"df93b370-5132-6be4-fbb2-632d6152a4e2\"")
    private WebElement continueButtonAfterLogin;

    public void clickToShoppingListButton() {
        shoppingListButton.click();
    }

    public void clickContinueButtonAfterLogin() {
        wait.until(ExpectedConditions.visibilityOf(continueButtonAfterLogin));
        continueButtonAfterLogin.click();
    }
}

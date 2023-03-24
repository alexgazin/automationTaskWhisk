package pages;

import Helper.WebHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingListPage extends PageObject {

    public ShoppingListPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(shoppingListAddItemButton));
    }

//    @FindBy(css = "[data-testid=\"plus\"")
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[1]/div[2]/div/div/div/div[1]/input")
    private WebElement shoppingListAddItemButton;

    @FindBy(css = "[data-testid=\"vertical-dots-shopping-list-button\"")
    private WebElement listOptions;

    @FindBy(css = "[data-testid=\"shopping-list-clear-list-menu-button\"")
    private WebElement clearListOptions;

    @FindBy(css = "[data-testid=\"shopping-lists-list-name\"")
    private WebElement titleOfThePage;

    public void clickToAddItemsInShoppingListButton() {
        wait.until(ExpectedConditions.visibilityOf(shoppingListAddItemButton));
        shoppingListAddItemButton.click();
    }

    public void clickToTitleOfThePage() {
        titleOfThePage.click();
    }

    public void checkElementWithText(String text) {
        WebHelper.methodForCheckElementWithText(text);
    }

    public void clickElementWithText(String text) {
        WebHelper.methodForClickElementWithText(text);
    }

    public void clickToShoppingOptionsList() {
        listOptions.click();
    }

    public void ClickToClearShoppingListOptions() {
        clearListOptions.click();
    }
}

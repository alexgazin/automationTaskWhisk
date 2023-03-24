package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ShoppingListPage;
import utils.Browser;

public class ShoppingListWebTests extends BaseTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private ShoppingListPage shoppingListPage;

    @Before
    public void init() {
        driver = Browser.launchBrowser();
        driver.manage().window().maximize();
        driver.get(CONFIGURATION.web_host());
    }

    @Test
    public void createItemsInShoppingList() {
        loginPage = new LoginPage(driver);
        loginPage.clickToSignUpButton();
        loginPage.fillEmailField(EMAIL);
        loginPage.clickToContinueSignUp();

        mainPage = new MainPage(driver);
        mainPage.clickContinueButtonAfterLogin();
        mainPage.clickToShoppingListButton();

        shoppingListPage = new ShoppingListPage(driver);
        shoppingListPage.clickToAddItemsInShoppingListButton();
        shoppingListPage.clickElementWithText("Milk");
        shoppingListPage.clickElementWithText("Bread");
        shoppingListPage.clickElementWithText("Onion");
        shoppingListPage.clickElementWithText("Butter");
        shoppingListPage.clickElementWithText("Cheese");

        shoppingListPage.clickToTitleOfThePage();

        shoppingListPage.checkElementWithText("Milk");
        shoppingListPage.checkElementWithText("Bread");
        shoppingListPage.checkElementWithText("Onion");
        shoppingListPage.checkElementWithText("Butter");
        shoppingListPage.checkElementWithText("Cheese");
    }

    @Test
    public void deleteInShoppingList() {
        loginPage = new LoginPage(driver);
        loginPage.clickToSignUpButton();
        loginPage.fillEmailField(EMAIL);
        loginPage.clickToContinueSignUp();

        mainPage = new MainPage(driver);
        mainPage.clickContinueButtonAfterLogin();
        mainPage.clickToShoppingListButton();

        shoppingListPage = new ShoppingListPage(driver);
        shoppingListPage.clickToAddItemsInShoppingListButton();
        shoppingListPage.clickElementWithText("Milk");
        shoppingListPage.clickElementWithText("Bread");
        shoppingListPage.clickElementWithText("Onion");
        shoppingListPage.clickElementWithText("Butter");
        shoppingListPage.clickElementWithText("Cheese");

        shoppingListPage.clickToTitleOfThePage();

        shoppingListPage.checkElementWithText("Milk");
        shoppingListPage.checkElementWithText("Bread");
        shoppingListPage.checkElementWithText("Onion");
        shoppingListPage.checkElementWithText("Butter");
        shoppingListPage.checkElementWithText("Cheese");

        shoppingListPage.clickToShoppingOptionsList();
        shoppingListPage.ClickToClearShoppingListOptions();
        shoppingListPage.checkElementWithText("Add something to your list");
        shoppingListPage.checkElementWithText("0 items");
    }
}

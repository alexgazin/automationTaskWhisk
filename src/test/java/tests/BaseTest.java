package tests;

import Helper.OperationsHelper;
import config.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    protected final String SHOPPING_LIST_NAME = "shoppingListName" + OperationsHelper.generateUid();
    protected final String EMAIL = "shoppingListName" + OperationsHelper.generateUid() + "@test.com";
    protected static final Configuration CONFIGURATION = ConfigFactory.create(Configuration.class, System.getProperties());

    protected static WebDriver driver;

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}


package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObject {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public PageObject(WebDriver driver) {
        PageObject.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }
}

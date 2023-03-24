package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    public static WebDriver launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        return new ChromeDriver(options);
    }
}

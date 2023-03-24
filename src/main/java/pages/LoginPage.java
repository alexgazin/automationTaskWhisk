package pages;

import Helper.WebHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(signUpButton));
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/nav[2]/button/div/div")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"_input-1\"]")
    private WebElement getSignUpViaEMail;

    @FindBy(css = "[data-testid=\"auth-continue-button\"")
    private WebElement continueButtonForSignUp;

    public void fillEmailField(String email){
        WebHelper.fillTextField(getSignUpViaEMail, email);
    }

    public void clickToSignUpButton(){
        signUpButton.click();
    }

    public void clickToContinueSignUp() {
        continueButtonForSignUp.click();
    }
}

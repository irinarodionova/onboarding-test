import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ForgotPasswordPage {

    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement emailField;
    @FindBy(xpath = "//div[text()=\"An email with a link to reset your password will be sent shortly.\"]")
    private WebElement emailSentText;
    @FindBy(xpath = "//div[text()=\"Must be valid email\"]")
    private WebElement invalidEmailText;
    @FindBy(xpath = "//button[@class=\"forgot_password\"]")
    private WebElement resetPasswordButton;
    @FindBy(xpath = "//div[text()=\"Required\"]")
    private WebElement requiredText;

    public WebElement getEmailSentText() {
        return emailSentText;
    }

    public WebElement getInvalidEmailText() {
        return invalidEmailText;
    }

    public WebElement getRequiredText() {
        return requiredText;
    }

    public ForgotPasswordPage resetPassword(String email) {
        emailField.sendKeys(email);
        resetPasswordButton.click();
        return this;
    }

    public ForgotPasswordPage typeUserEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
}




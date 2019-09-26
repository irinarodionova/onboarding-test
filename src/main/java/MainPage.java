import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//div/span[text()=\"Accept\"]")
    private WebElement acceptCockies;
    @FindBy(xpath = "//input[@name=\"username\"]")
    private WebElement emailField;
    @FindBy (xpath = "//input[@name=\"password\"]")
    private WebElement passwordField;
    @FindBy (xpath = "//a[text()=\"Forgot Password?\"]")
    private WebElement forgotPassword;
    @FindBy (xpath = "//button[@class='signin']/div/span")
    private WebElement signInButton;
    @FindBy(xpath = "//span[text()=\"Sign up\"]")
    private WebElement signUpButton;
    @FindBy(xpath = "//div[text()=\"The email or password you entered is invalid. Please try again.\"]")
    private WebElement invalidCredentialsText;
    @FindBy(xpath = "//div[text()=\"Must be valid email\"]")
    private WebElement invalidEmailText;
    @FindBy(xpath = "//div[text()=\"Required\"]")
    private WebElement requiredText;
    @FindBy(xpath = "//div[text()=\"Required\"]")
    private List<WebElement> requiredTexts;

    public WebElement getInvalidCredentialsText() {
        return invalidCredentialsText;
    }

    public WebElement getInvalidEmailText() {
        return invalidEmailText;
    }

    public WebElement getRequiredText() {
        return requiredText;
    }

    public List<WebElement> getRequiredTexts() {
        return requiredTexts;
    }

    public MainPage clickAcceptCoockie() {
        acceptCockies.click();
        return this;
    }

    public MainPage typeUserEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public MainPage typeUserPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage clickSignInButton(){
        signInButton.click();
        return new HomePage(driver);
    }

    public SignUpPage clicSignUpFormButton(){
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public ForgotPasswordPage clicForgotPasswordButton(){
        forgotPassword.click();
        return new ForgotPasswordPage(driver);
    }

    public HomePage login(String email, String password) {
        this.typeUserEmail(email);
        this.typeUserPassword(password);
        this.clickSignInButton();
        return new HomePage(driver);
    }

    public MainPage errorLogin(String email, String password) {
        this.typeUserEmail(email);
        this.typeUserPassword(password);
        this.clickSignInButton();
        return this;
    }
}

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordTest {

    private WebDriver driver;
    private MainPage mainPage;
    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://you.sharecare.com/");
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void clickForgotPasswordAndExpectEmailSendTest() {
        mainPage = mainPage.clickAcceptCoockie();
        forgotPasswordPage = mainPage.clicForgotPasswordButton();
        forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);
        forgotPasswordPage = forgotPasswordPage.resetPassword("rodionova.ig@yandex.ru");

        assert forgotPasswordPage.getEmailSentText().getText() != null;
    }

    @Test
    public void typeIncorrectEmailAndExpectErrorTest() {
        mainPage = mainPage.clickAcceptCoockie();
        forgotPasswordPage = mainPage.clicForgotPasswordButton();
        forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);
        forgotPasswordPage = forgotPasswordPage.typeUserEmail("rodionova.igyandex");

        assert forgotPasswordPage.getInvalidEmailText().getText() != null;
    }

    @Test
    public void typeNoEmailAndExpectErrorTest() {
        mainPage = mainPage.clickAcceptCoockie();
        forgotPasswordPage = mainPage.clicForgotPasswordButton();
        forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);
        forgotPasswordPage = forgotPasswordPage.resetPassword("");

        assert forgotPasswordPage.getRequiredText().getText() != null;
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}


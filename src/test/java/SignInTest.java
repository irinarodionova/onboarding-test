import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class SignInTest {

    private WebDriver driver;
    private MainPage mainPage;
    private HomePage homePage;

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
    public void signInExistingUserTest() {
        mainPage = mainPage.clickAcceptCoockie();
        homePage = mainPage.login("rodionova.ig@yandex.ru", "YW9xD@wLg2@KEZC");
        homePage = PageFactory.initElements(driver, HomePage.class);
        assert homePage.getNavBar() != null;
    }

    @Test
    public void signInNonExistingUserAndExpectErrorTest() {
        mainPage = mainPage.clickAcceptCoockie();
        mainPage = mainPage.errorLogin("rodionova.ig@yandex.ru", "YW9xD@wLg2@KEZC1");
        assert mainPage.getInvalidCredentialsText().getText() != null;
    }

    @Test
    public void signInIncorrectEmailAndExpectErrorTest() {
        mainPage = mainPage.clickAcceptCoockie();
        mainPage = mainPage.errorLogin("rodionova.igyandex", "YW9xD@wLg2@KEZC1");
        assert mainPage.getInvalidEmailText().getText() != null;
    }

    @Test
    public void signInWithoutEmailAndExpectErrorTest() {
        mainPage = mainPage.clickAcceptCoockie();
        mainPage = mainPage.errorLogin("", "123");
        assert mainPage.getRequiredText().getText() != null;
    }

    @Test
    public void signInWithoutPasswordAndExpectErrorTest() {
        mainPage = mainPage.clickAcceptCoockie();
        mainPage = mainPage.errorLogin("rodionova.ig@yandex.ru", "");
        assert mainPage.getRequiredText().getText() != null;
    }

    @Test
    public void signInWithoutEmailAndPasswordAndExpectErrorTest() {
        mainPage = mainPage.clickAcceptCoockie();
        mainPage = mainPage.errorLogin("", "");
        assert mainPage.getRequiredTexts().size() == 2;
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}


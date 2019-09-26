import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
    this.driver = driver;
}

    @FindBy(xpath = "//div[@class=\"main-nav\"]")
    private WebElement navBar;

    public WebElement getNavBar() {
        return navBar;
    }
}


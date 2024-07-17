import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {


    private WebDriver driver;
    private WebDriverWait wait;

    private static final String usernameInputCSSLocator ="#user-name";
    private static final String passwordInputCSSLocator = "#password";
    private static final String loginButtonInputCSSLocator = "#login-button";
    private static final String errorMessageCSSLocator = "";

    @FindBy(css = usernameInputCSSLocator)
    private WebElement usernameInput;

    @FindBy(css = passwordInputCSSLocator)
    private WebElement passwordInput;

    @FindBy(css= loginButtonInputCSSLocator)
    private WebElement loginButton;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

        PageFactory.initElements(this.driver,this);
    }

    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
}



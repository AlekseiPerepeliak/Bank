import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankLoginPage {

    @FindBy(name = "username")
    WebElement usernameLoginField;

    @FindBy(name = "password")
    WebElement passwordLoginField;

    @FindBy(id = "login-button")
    WebElement loginButton;


    public BankLoginPage enterUsersCredentials(String username, String password) {
        usernameLoginField.clear();
        usernameLoginField.sendKeys(username);
        passwordLoginField.clear();
        passwordLoginField.sendKeys(password);
        return PageFactory.initElements(BrowserManager.browser, BankLoginPage.class);
    }

    public BankLoginAutentificationPage clickLoginButton() {
        loginButton.click();
        return PageFactory.initElements(BrowserManager.browser, BankLoginAutentificationPage.class);
    }

}

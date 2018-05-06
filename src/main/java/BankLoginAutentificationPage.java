import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankLoginAutentificationPage {

    @FindBy(id = "otp-code")
    WebElement optCodeField;

    @FindBy(id = "login-otp-button")
    WebElement loginOPTbutton;

    public BankLoginAutentificationPage enterAuthenticationCode(int code) {
        optCodeField.clear();
        optCodeField.sendKeys(String.valueOf(code));
        return PageFactory.initElements(BrowserManager.browser, BankLoginAutentificationPage.class);
    }

    public BankHomePage clickOPTloginButton() {
        loginOPTbutton.click();
        return PageFactory.initElements(BrowserManager.browser, BankHomePage.class);
    }
}

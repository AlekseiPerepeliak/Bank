import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankLoginAutentificationPage {

    //code  number is 0000
    @FindBy(id = "otp-code")
    WebElement optCodeField;

    @FindBy(id = "login-otp-button")
    WebElement loginOPTbutton;

    public BankLoginAutentificationPage enterAuthenticationCode(String code) {
        //TODO How to handle integer with Send Keys()
        optCodeField.clear();
        optCodeField.sendKeys(code);
        return PageFactory.initElements(BrowserManager.browser, BankLoginAutentificationPage.class);
    }

    public BankHomePage clickOPTloginButton() {
        loginOPTbutton.click();
        return PageFactory.initElements(BrowserManager.browser, BankHomePage.class);
    }
}

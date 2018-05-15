package Pages;

import Framework.BrowserManager;
import Framework.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankLoginAutentificationPage {

    @FindBy(id = "otp-code")
    WebElement optCodeField;

    @FindBy(id = "login-otp-button")
    WebElement loginOPTbutton;

    public BankLoginAutentificationPage enterAuthenticationCode(String code) {
        optCodeField.clear();
        optCodeField.sendKeys(code);
        return PageFactory.initElements(BrowserManager.browser, BankLoginAutentificationPage.class);
    }

    public BankHomePage clickOPTloginButton() {
        Utils.waitForElementPresentById(loginOPTbutton);
        Utils.clickWithJS(loginOPTbutton);
        return PageFactory.initElements(BrowserManager.browser, BankHomePage.class);
    }
}

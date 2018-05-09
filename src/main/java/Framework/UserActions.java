package Framework;

import Pages.BankHomePage;
import org.openqa.selenium.support.PageFactory;

public class UserActions {

    public BankHomePage loginWithUser(String name, String pass, String authenticationCode){
        Navigation
                .openLoginPage()
                .enterUsersCredentials(name, pass)
                .clickLoginButton()
                .enterAuthenticationCode(authenticationCode)
                .clickOPTloginButton();
        return PageFactory.initElements(BrowserManager.browser, BankHomePage.class);

    }
}

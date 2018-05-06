import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountBalanceTest {

    String USERNAME = new BaseTestParams().username;
    String USER_PASSWORD = new BaseTestParams().user_pass;
    int AUTHENTICATION_CODE = new BaseTestParams().authentication_code;

    @BeforeClass
    public void browser() {
        BrowserManager.openBrowser();
    }

    @Test
    public void checkAccountBaance() {
        double closingBalance =
                Navigation
                        .openLoginPage()
                        .enterUsersCredentials(USERNAME, USER_PASSWORD)
                        .clickLoginButton().
                        enterAuthenticationCode(AUTHENTICATION_CODE)
                        .clickOPTloginButton()
                        .mouseHoverAccountsTab()
                        .openAccountsStatement()
                        .clickQueryBalanceButton()
                        .getClosingBalance();
        assert closingBalance > 0;
    }

    @AfterClass
    public void closeBrowser() {
        BrowserManager.closeBrowser();
    }
}



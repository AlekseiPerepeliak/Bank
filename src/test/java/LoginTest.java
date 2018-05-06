import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {

    String USERNAME = new BaseTestParams().username;
    String USER_PASSWORD = new BaseTestParams().user_pass;
    int AUTHENTICATION_CODE = new BaseTestParams().authentication_code;

    @BeforeClass
    public void browser() {
        BrowserManager.openBrowser();
    }


    @Test
    public void loginAsRegisteredUser() {
        String accountOwnerName =
                Navigation
                        .openLoginPage()
                        .enterUsersCredentials(USERNAME, USER_PASSWORD)
                        .clickLoginButton()
                        .enterAuthenticationCode(AUTHENTICATION_CODE)
                        .clickOPTloginButton().getUserName();
        assertTrue(accountOwnerName.contains("Королёва Ольга"));
    }

    @AfterClass
    public void closeBrowser() {
        BrowserManager.closeBrowser();
    }
}


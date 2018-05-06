import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MessageTest {
    @BeforeClass
    public void browser() {
        BrowserManager.openBrowser();
    }

    String MESSAGE_TEXT = "This is the test message!";
    String USERNAME = new BaseTestParams().username;
    String USER_PASSWORD = new BaseTestParams().user_pass;
    int AUTHENTICATION_CODE = new BaseTestParams().authentication_code;

    @Test
    public void sendNewMessage() {
        String actualMessageTest =
                Navigation
                        .openLoginPage()
                        .enterUsersCredentials(USERNAME, USER_PASSWORD)
                        .clickLoginButton()
                        .enterAuthenticationCode(AUTHENTICATION_CODE)
                        .clickOPTloginButton()
                        .clickMessageIcon()
                        .clickNewMessageButton()
                        .enterMessageText(MESSAGE_TEXT)
                        .clickSendMessageButton()
                        .getAllMessagesText();
        assertTrue(actualMessageTest.contains(MESSAGE_TEXT));
    }

    @AfterClass
    public void closeBrowser() {
        BrowserManager.closeBrowser();
    }
}

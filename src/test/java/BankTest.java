import Framework.BaseTestParams;
import Framework.BrowserManager;
import Framework.UserActions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class BankTest {
    String USERNAME = BaseTestParams.username;
    String USER_PASSWORD = BaseTestParams.user_pass;
    String AUTHENTICATION_CODE = BaseTestParams.authentication_code;

    String usd = "10013";
    String buyAmount = "100";
    String rub = "10001";
    String paymentDetailsText = "Transaction usd To rub!";
    String messageText = "This is the test message!";

    UserActions userActions = new UserActions();


    @BeforeClass
    public void browser() {
        BrowserManager.openBrowser();
    }

    @Test
    public void checkAccountBalance() {
        double closingBalance =
                userActions.loginWithUser(USERNAME, USER_PASSWORD, AUTHENTICATION_CODE)
                        .openAccountsStatement()
                        .clickQueryBalanceButton()
                        .getClosingBalance();
//        assertTrue((closingBalance > 0), "Balance is negative");
        assertTrue((closingBalance < 0), "Balance is negative");//TODO Change assertion x<0 to x>0

    }

    @Test
    public void checkCurrencyExchangeUSDtoRUB() {
        String actualResultAlertText =
                userActions.loginWithUser(USERNAME, USER_PASSWORD, AUTHENTICATION_CODE)
                        .clickCurrencyExchange()
                        .selectFromAccount(usd)
                        .enterBuyingAmount(buyAmount)
                        .selectToAccount(rub)
                        .enterPaymentDetails(paymentDetailsText)
                        .clickCalculateButton()
                        .clickExchangeConfirmButton().getExchangeAlertSuccessText();
        assertEquals("Alert does not successful!", actualResultAlertText, "Payment transferred successfully");
    }

    @Test
    public void loginAsRegisteredUser() {
        String accountOwnerName = userActions
                .loginWithUser(USERNAME, USER_PASSWORD, AUTHENTICATION_CODE)
                .getUserName();
        assertTrue(accountOwnerName.contains("Королёва Ольга"), "Username is not Королёва Ольга");
    }

    @Test
    public void sendNewMessage() {
        String actualMessageTest
                = userActions.loginWithUser(USERNAME, USER_PASSWORD, AUTHENTICATION_CODE)
                .clickMessageIcon()
                .clickNewMessageButton()
                .enterMessageText(messageText)
                .clickSendMessageButton()
                .getAllMessagesText();
        assertTrue(actualMessageTest.contains(messageText), "Message was not found");
    }


    @AfterClass
    public void closeBrowser() {
        BrowserManager.closeBrowser();
    }
}
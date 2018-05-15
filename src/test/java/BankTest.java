import Framework.BaseTestParams;
import Framework.BrowserManager;
import Framework.CSVDataProvider;
import Framework.UserActions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class BankTest extends BaseTestParams{

    String usd = "10013";
    String buyAmount = "100";
    String rub = "10001";
    String paymentDetailsText = "Transaction usd To rub!";


    @BeforeClass
    public void browser() {
        BrowserManager.openBrowser();
    }

    @DataProvider(name = "csv")
    public Iterator<Object[]> searchFromCsv() {
        return CSVDataProvider.loadDataFromFile();
    }

    @Test
    public void checkAccountBalance() {
        double closingBalance =
                UserActions.loginWithUser(USERNAME, USER_PASSWORD, AUTHENTICATION_CODE)
                        .openAccountsStatement()
                        .clickQueryBalanceButton()
                        .getClosingBalance();
        assertTrue((closingBalance > 0), "Balance is negative");

    }

    @Test
    public void checkCurrencyExchangeUSDtoRUB() {
        String actualResultAlertText =
                UserActions.loginWithUser(USERNAME, USER_PASSWORD, AUTHENTICATION_CODE)
                        .clickCurrencyExchange()
                        .selectFromAccount(usd)
                        .enterBuyingAmount(buyAmount)
                        .selectToAccount(rub)
                        .enterPaymentDetails(paymentDetailsText)
                        .clickCalculateButton()
                        .clickExchangeConfirmButton().getExchangeAlertSuccessText();
        assertEquals("Alert does not successful!", "Payment transferred successfully", actualResultAlertText);
    }

    @Test
    public void loginAsRegisteredUser() {
        String accountOwnerName = UserActions
                .loginWithUser(USERNAME, USER_PASSWORD, AUTHENTICATION_CODE)
                .getUserName();
        assertTrue(accountOwnerName.contains("Королёва Ольга"), "Username is not Королёва Ольга");
    }

    @Test(dataProvider = "csv")
    public void sendNewMessage(String message) {
        String actualMessageTest
                = UserActions.loginWithUser(USERNAME, USER_PASSWORD, AUTHENTICATION_CODE)
                .clickMessageIcon()
                .clickNewMessageButton()
                .enterMessageText(message)
                .clickSendMessageButton()
                .getAllMessagesText();
        assertTrue(actualMessageTest.contains(message), "Message was not found");
    }


    @AfterClass
    public void closeBrowser() {
        BrowserManager.closeBrowser();
    }
}

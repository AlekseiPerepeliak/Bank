import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CurrencyExchangeTest {

    String USD = "10013";
    String BUY_AMOUNT = "100";
    String RUB = "10001";

    String USERNAME = "";
    String USER_PASSWORD = "";
    String AUTHENTICATION_CODE = "";
    String PAYMENT_DETAILS_TEXT = "Transaction USD To RUB!";

    @BeforeClass
    public void browser() {
        BrowserManager.openBrowser();
    }


    @Test
    public void checkCurrencyExchangeUSDtoRUB() {
        String actualResultAlertText =
                Navigation
                        .openLoginPage()
                        .enterUsersCredentials(USERNAME, USER_PASSWORD)
                        .clickLoginButton()
                        .enterAuthenticationCode(AUTHENTICATION_CODE)
                        .clickOPTloginButton()
                        .mouseHoverCurrency()
                        .clickCurrencyExchange()
                        .selectFromAccount(USD)
                        .enterBuyingAmount(BUY_AMOUNT)
                        .selectToAccount(RUB)
                        .enterPaymentDetails(PAYMENT_DETAILS_TEXT)
                        .clickCalculateButton()
                        .clickExchangeConfirmButton().getExchangeAlertSuccessText();
        assertEquals("Alert does not successful!", actualResultAlertText, "Payment transferred successfully");
    }

    @AfterClass
    public void closeBrowser() {
        BrowserManager.closeBrowser();
    }
}

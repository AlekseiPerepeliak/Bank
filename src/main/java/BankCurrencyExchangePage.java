import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BankCurrencyExchangePage {
    @FindBy(id = "acc1")
    WebElement fromAccountDropDown;

    @FindBy(id = "from-amount")
    WebElement fromAmountField;

    @FindBy(id = "acc2")
    WebElement toAccountDropDown;

    @FindBy(id = "to-amount")
    WebElement toAmountField;

    @FindBy(name = "payment.details")
    WebElement paymentDetailsField;

    @FindBy(id = "forward")
    WebElement paymentCalculateButton;

    public BankCurrencyExchangePage selectFromAccount(String value) {
        Select dropdown = new Select(fromAccountDropDown);
        dropdown.selectByValue(value); //10013
        return PageFactory.initElements(BrowserManager.browser, BankCurrencyExchangePage.class);
    }

    public BankCurrencyExchangePage enterSellingAmount(String amount) {
        fromAmountField.sendKeys(amount);//100
        return PageFactory.initElements(BrowserManager.browser, BankCurrencyExchangePage.class);
    }

    public BankCurrencyExchangePage selectToAccount(String value) {
        Select dropdown = new Select(toAccountDropDown);
        dropdown.selectByValue(value); //10001
        return PageFactory.initElements(BrowserManager.browser, BankCurrencyExchangePage.class);
    }

    public BankCurrencyExchangePage enterBuyingAmount(String amount) {
        toAmountField.sendKeys(amount);
        return PageFactory.initElements(BrowserManager.browser, BankCurrencyExchangePage.class);
    }

    public BankCurrencyExchangePage enterPaymentDetails(String detailsText) {
        paymentDetailsField.sendKeys(detailsText);
        return PageFactory.initElements(BrowserManager.browser, BankCurrencyExchangePage.class);

    }

    public BankCurrencyExchangePage clickCalculateButton() {
        paymentCalculateButton.click();
        return PageFactory.initElements(BrowserManager.browser, BankCurrencyExchangePage.class);
    }

    public BankCurrencyExchangePage clickExchangeConfirmButton() {
        BrowserManager.browser.switchTo().frame("confirmation-frame");
        BrowserManager.browser.findElement(By.id("confirm")).click();
        BrowserManager.browser.switchTo().defaultContent();
        return PageFactory.initElements(BrowserManager.browser, BankCurrencyExchangePage.class);
    }

    public String getExchangeAlertSuccessText() {
        String alertSuccessText = BrowserManager.browser.findElement(By.cssSelector(".alert.alert-success")).getText();
        return alertSuccessText;
    }
}

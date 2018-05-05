import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankHomePage {

    @FindBy(css = ".btn.dropdown-toggle.selectpicker.btn-default")
    WebElement accountOwnerName;

    @FindBy(id = "statements-statement")
    WebElement accountStatement;

    @FindBy(id = "accounts-index")
    WebElement accountsTab;

    @FindBy(id = "statements-statement")
    WebElement statements;

    @FindBy(id = "currency")
    WebElement cuurrencyTab;

    @FindBy(id = "currency-exchange")
    WebElement currencies;

    @FindBy(id = "messages-button")
    WebElement messageIcon;

    public String getUserName() {
        String name = accountOwnerName.getText();
        return name;
    }

    public BankHomePage mouseHoverAccountsTab() {
        Actions actions = new Actions(BrowserManager.browser);
        actions.moveToElement(accountsTab).build().perform();
        return PageFactory.initElements(BrowserManager.browser, BankHomePage.class);
    }

    public AccountsPage openAccountsStatement() {
        accountStatement.click();
        return PageFactory.initElements(BrowserManager.browser, AccountsPage.class);
    }

    public BankHomePage mouseHoverCurrency() {
        Actions actions = new Actions(BrowserManager.browser);
        actions.moveToElement(cuurrencyTab).build().perform();
        return PageFactory.initElements(BrowserManager.browser, BankHomePage.class);
    }

    public BankCurrencyExchangePage clickCurrencyExchange() {
        currencies.click();
        return PageFactory.initElements(BrowserManager.browser, BankCurrencyExchangePage.class);
    }

    public BankMessagesPage clickMessageIcon() {
        messageIcon.click();
        return PageFactory.initElements(BrowserManager.browser, BankMessagesPage.class);
    }


}

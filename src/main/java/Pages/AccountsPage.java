package Pages;

import Framework.BrowserManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

    @FindBy(id = "query-button")
    WebElement queryButton;

    @FindBy(xpath = "//tr[@id='closing-balance-row']/th[@class='right amount']")
    WebElement closingBalanceRow;


    public AccountsPage clickQueryBalanceButton() {
        queryButton.click();
        return PageFactory.initElements(BrowserManager.browser, AccountsPage.class);
    }

    public double getClosingBalance() {
        String closingBalanceRowText = closingBalanceRow.getText();
        String closingBalance = closingBalanceRowText.replace(" ", "");
        return Double.parseDouble(closingBalance);
    }


}

package Pages;

import Framework.BrowserManager;
import Framework.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankMessagesPage {

    @FindBy(id = "new-message-btn")
    WebElement newMessageButton;

    @FindBy(name = "message.text")
    WebElement messageTextField;

    @FindBy(id = "send-button")
    WebElement sendMessageButton;

    @FindBy(id = "messages")
    WebElement allMessageText;

    public BankMessagesPage clickNewMessageButton() {
        newMessageButton.click();
        return PageFactory.initElements(BrowserManager.browser, BankMessagesPage.class);
    }

    public BankMessagesPage enterMessageText(String text) {
        messageTextField.sendKeys(text);
        return PageFactory.initElements(BrowserManager.browser, BankMessagesPage.class);

    }

    public BankMessagesPage clickSendMessageButton() {
        sendMessageButton.click();
        return PageFactory.initElements(BrowserManager.browser, BankMessagesPage.class);
    }

    public String getAllMessagesText() {
        new Utils().WAIT_FOR_ELEMENT_PRESENT_BY_ID(allMessageText);
        return allMessageText.getText();

    }
}

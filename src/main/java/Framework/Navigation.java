package Framework;

import Pages.BankLoginPage;
import org.openqa.selenium.support.PageFactory;

public class Navigation {

    public static String loginBankUrl = "https://idemo.bspb.ru/";

    public static BankLoginPage openLoginPage(){
        BrowserManager.browser.get(loginBankUrl);
        return PageFactory.initElements(BrowserManager.browser, BankLoginPage.class);
    }
}

package Framework;

import Pages.BankLoginAutentificationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.WEmbeddedFrame;

public class Utils {

    public static final Actions MOUSE_HOVER_ELEMENT(WebElement element) {
        Actions actions = new Actions(BrowserManager.browser);
        actions.moveToElement(element).build().perform();
        return PageFactory.initElements(BrowserManager.browser, Actions.class);
    }

    public static final Utils WAIT_FOR_ELEMENT_PRESENT_BY_ID(WebElement elementId) {
        new WebDriverWait(BrowserManager.browser, 10)
                .until(ExpectedConditions.presenceOfElementLocated((By)elementId));
        return PageFactory.initElements(BrowserManager.browser, Utils.class);
    }
    public static final Utils CLICK_WITH_JAVA_SCRIPT(WebElement id){
//        WebElement element = BrowserManager.browser.findElement(By.id(id));
        JavascriptExecutor executor = (JavascriptExecutor)BrowserManager.browser;
        executor.executeScript("arguments[0].click();", id);
        return PageFactory.initElements(BrowserManager.browser, Utils.class);
    }

}

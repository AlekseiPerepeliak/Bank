package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static void mouseHoverElement(WebElement element) {
        Actions actions = new Actions(BrowserManager.browser);
        actions.moveToElement(element).build().perform();
    }

    public static void waitForElementPresentById(WebElement elementId) {
        new WebDriverWait(BrowserManager.browser, 10)
                .until(ExpectedConditions.presenceOfElementLocated((By)elementId));
    }
    public static void clickWithJS(WebElement id){
        JavascriptExecutor executor = (JavascriptExecutor)BrowserManager.browser;
        executor.executeScript("arguments[0].click();", id);
    }

}

package Framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Utils {

    public static final Actions mouseHoverElement(WebElement element){
        Actions actions = new Actions(BrowserManager.browser);
        actions.moveToElement(element).build().perform();
        return PageFactory.initElements(BrowserManager.browser, Actions.class);
    }
}

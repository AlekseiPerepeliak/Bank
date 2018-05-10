package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager {

    public static WebDriver browser;

    public static void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "./target/classes/geckodriver.exe");
        browser = new FirefoxDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public static void closeBrowser() {
        browser.quit();
    }
}

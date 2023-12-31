package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverUtils {

    public static final int TIME_SECONDS = 3;
    public static WebDriver driver = getWebDriver("firefox");
    public static final String WEBSITE = "C:\\tools\\qa-test.html";
    public static final String MESSAGE_ALERT_NOT_OPEN = "Сообщение об ошибке не появилось";

    public static WebDriver getWebDriver(String browserName){
        switch ((browserName)){
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            case "chrome":
                return new ChromeDriver();
            default:
                throw new RuntimeException("Incorrect Browser Name");
        }
    }

    public static void startBrowser(String site){
        driver.get(site);
    }

    public static void timeout(WebDriver driver, int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public static void clickOnInteractiveElement(WebDriver driver, By locator){
        driver.findElement(locator).click();
    }

    public static void sendText(WebDriver driver,String text, By locator){
        driver.findElement(locator).sendKeys(text);
    }
}

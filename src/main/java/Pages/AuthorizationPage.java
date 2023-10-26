package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;


public class AuthorizationPage {
    public static final By EMAILEXPATH = By.xpath("//input[@id='loginEmail']");
    public static final By PASSWORDEXPATH = By.xpath("//input[@id='loginPassword']");
    public static final By ERROR_MASSAGE = By.xpath("//div[@id='authAlertsHolder']");
    public static final By BTN_INPUT = By.xpath("//button[@id='authButton']");
    public static final String USEREMAIL = "test@protei.ru";
    public static final String USERPASSWORD = "test";
    public static final String WEBSITE = "C:\\tools\\qa-test.html";
    public static WebElement element;


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

    public static void startBrowser(WebDriver driver, String site){
        driver.get(site);
    }
    public static void timeout(WebDriver driver, int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public static void clickOnInteractiveElement(WebDriver driver, By locator){
        element = driver.findElement(locator);
        element.click();
    }
    public static void sendText(String text){
        element.sendKeys(text);
    }
}


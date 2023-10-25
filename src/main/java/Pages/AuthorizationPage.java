package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AuthorizationPage {
    public static final String USEREMAIL = "test@protei.ru";
    public static final String USERPASSWORD = "test";
    public static final String EMAILEXPATH = "//input[@id='loginEmail']";
    public static final String PASSWORDEXPATH = "//input[@id='loginPassword']";
    public static final String ERROR_MASSAGE = "//div[@id='authAlertsHolder']";
    public static final String WEBSITE = "C:\\tools\\qa-test.html";
    public static WebElement element;

    public static void startBrowser(FirefoxDriver driver, String site){
        driver.get(site);
    }

    public static void clickOnInteractiveElement(FirefoxDriver driver, String locator){
        element = driver.findElement(By.xpath(locator));
        element.click();
    }
    public static void sendText(String text){
        element.sendKeys(text);
    }
}


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataTest {
    static final String USEREMAIL = "test@protei.ru";
    static final String USERPASSWORD = "test";
    static final String EMAILEXPATH = "//input[@id='loginEmail']";
    static final String PASSWORDEXPATH = "//input[@id='loginPassword']";
    static final String Website = "C:\\tools\\qa-test.html";
    static WebElement element;

    public void clickOnTop(FirefoxDriver driver, String locator){
        element = driver.findElement(By.xpath(locator));
        element.click();
    }
    public void sendText(String text){
        element.sendKeys(text);
    }
}


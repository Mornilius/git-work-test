import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataTest {
    static final String USEREMAIL = "protei@test.ru";
    static final String USERPASSWORD = "test";
    static final String EMAILEXPATH = "input[@id='loginEmail']";
    static final String PASSWORDEXPATH = "input[@id='loginPassword']";
    static final String Website = "C:\\tools\\qa-test.html";
    static WebElement element;


    public void click(WebDriver driver, String locator){
        element = driver.findElement(By.xpath(locator));
        element.click();
    }
}


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        DataTest datatest = new DataTest();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(DataTest.Website);
        datatest.clickOnTop(driver, DataTest.EMAILEXPATH);
        datatest.sendText(DataTest.USEREMAIL);
        datatest.clickOnTop(driver, DataTest.PASSWORDEXPATH);
        datatest.sendText(DataTest.USERPASSWORD);
        datatest.clickOnTop(driver, "//button[@id='authButton']");




    }
}

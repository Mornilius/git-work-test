import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        DataTest datatest = new DataTest();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(DataTest.Website);





    }
}

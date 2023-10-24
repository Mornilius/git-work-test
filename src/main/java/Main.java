import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

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

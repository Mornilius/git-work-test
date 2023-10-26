import Pages.AuthorizationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        startWork();
    }
    public static void startWork(){
        WebDriver driver = AuthorizationPage.getWebDriver("firefox");
        AuthorizationPage datatest = new AuthorizationPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        datatest.startBrowser(driver, AuthorizationPage.WEBSITE);
        datatest.clickOnInteractiveElement(driver,AuthorizationPage.EMAILEXPATH);
        datatest.sendText(AuthorizationPage.USEREMAIL);
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.PASSWORDEXPATH);
        datatest.sendText(AuthorizationPage.USERPASSWORD);
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
    }
}

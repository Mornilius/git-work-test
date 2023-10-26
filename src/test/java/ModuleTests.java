import Pages.AuthorizationPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.testng.Assert.assertTrue;


public class ModuleTests {
    FirefoxDriver driver = new FirefoxDriver();
    @Test
    void startBrowserTest(){
        driver.get(AuthorizationPage.WEBSITE);
        assertTrue(driver.findElement(By.xpath("//button[@id='authButton']")).isDisplayed());
    }
    @Test
    void clickAndSendEmail() throws InterruptedException {
        startBrowserTest();
        Thread.sleep(5000);
        AuthorizationPage.element = driver.findElement(AuthorizationPage.EMAILEXPATH);
        AuthorizationPage.element.sendKeys(AuthorizationPage.USEREMAIL);
        AuthorizationPage.element.sendKeys(Keys.ENTER);
        String a = AuthorizationPage.element.getText();
        driver.quit();
    }
    @Test
    void clickAndSendPassword(){
        startBrowserTest();
        AuthorizationPage.element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        AuthorizationPage.element.click();
        AuthorizationPage.element.sendKeys(AuthorizationPage.USERPASSWORD);
    }
}

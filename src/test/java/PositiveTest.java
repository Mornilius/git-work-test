import Pages.AuthorizationPage;
import Pages.SecondPage;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PositiveTest {
    FirefoxDriver driver = new FirefoxDriver();
    AuthorizationPage datatest = new AuthorizationPage();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    @Test
    public void correctInput() throws InterruptedException {
        driver.get(AuthorizationPage.WEBSITE);
        Thread.sleep(2000);

        AuthorizationPage.element = driver.findElement(By.xpath(AuthorizationPage.EMAILEXPATH));
        AuthorizationPage.element.sendKeys(AuthorizationPage.USEREMAIL);

        AuthorizationPage.element = driver.findElement(By.xpath(AuthorizationPage.PASSWORDEXPATH));
        AuthorizationPage.element.sendKeys(AuthorizationPage.USERPASSWORD);
        datatest.clickOnInteractiveElement(driver, "//button[@id='authButton']");
        assertTrue(SecondPage.isPageDisplay(driver));
        driver.quit();
    }
    @Test
    public void incorrectData() throws InterruptedException {
        driver.get(AuthorizationPage.WEBSITE);
        Thread.sleep(2000);
        AuthorizationPage.element = driver.findElement(By.xpath(AuthorizationPage.EMAILEXPATH));
        AuthorizationPage.element.sendKeys("dsd");
        AuthorizationPage.element = driver.findElement(By.xpath(AuthorizationPage.PASSWORDEXPATH));
        AuthorizationPage.element.sendKeys("wwww");
        datatest.clickOnInteractiveElement(driver, "//button[@id='authButton']");
        assertFalse(SecondPage.isPageDisplay(driver));
        Thread.sleep(5000);
        assertTrue(driver.findElement(By.xpath(AuthorizationPage.ERROR_MASSAGE)).isDisplayed());
        driver.quit();
    }
}

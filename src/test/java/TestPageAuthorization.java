import Pages.AuthorizationPage;
import Pages.SecondPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestPageAuthorization {
    FirefoxDriver driver = new FirefoxDriver();
    AuthorizationPage datatest = new AuthorizationPage();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    @Test
    public void correctInput() {
        driver.get(AuthorizationPage.WEBSITE);
        AuthorizationPage.timeout(driver,3);

        AuthorizationPage.element = driver.findElement(AuthorizationPage.EMAILEXPATH);
        AuthorizationPage.element.sendKeys(AuthorizationPage.USEREMAIL);

        AuthorizationPage.element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        AuthorizationPage.element.sendKeys(AuthorizationPage.USERPASSWORD);
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        AuthorizationPage.timeout(driver,3);

        assertTrue(SecondPage.isPageDisplay(driver));

    }
    @Test
    public void incorrectData() {
        driver.get(AuthorizationPage.WEBSITE);
        AuthorizationPage.timeout(driver,3);

        AuthorizationPage.element = driver.findElement(AuthorizationPage.EMAILEXPATH);
        AuthorizationPage.element.sendKeys("dsd");
        AuthorizationPage.element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        AuthorizationPage.element.sendKeys("wwww");
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        assertFalse(SecondPage.isPageDisplay(driver));
        AuthorizationPage.timeout(driver,3);

        assertTrue(driver.findElement(AuthorizationPage.ERROR_MASSAGE).isDisplayed());

    }@Test
    public void incorrectPassword() {
        driver.get(AuthorizationPage.WEBSITE);
        AuthorizationPage.timeout(driver,3);

        AuthorizationPage.element = driver.findElement(AuthorizationPage.EMAILEXPATH);
        AuthorizationPage.element.sendKeys(AuthorizationPage.USEREMAIL);
        AuthorizationPage.element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        AuthorizationPage.element.sendKeys("wwww");
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        assertFalse(SecondPage.isPageDisplay(driver));
        AuthorizationPage.timeout(driver,3);

        assertTrue(driver.findElement(AuthorizationPage.ERROR_MASSAGE).isDisplayed());

    }@Test
    public void incorrectEmail() {
        driver.get(AuthorizationPage.WEBSITE);
        AuthorizationPage.timeout(driver,3);

        AuthorizationPage.element = driver.findElement(AuthorizationPage.EMAILEXPATH);
        AuthorizationPage.element.sendKeys("AuthorizationPage.USEREMAIL");
        AuthorizationPage.element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        AuthorizationPage.element.sendKeys(AuthorizationPage.USERPASSWORD);
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        assertFalse(SecondPage.isPageDisplay(driver));
        AuthorizationPage.timeout(driver,3);

        assertTrue(driver.findElement(AuthorizationPage.ERROR_MASSAGE).isDisplayed());

    }@Test
    public void emptyEmailPassword() {
        driver.get(AuthorizationPage.WEBSITE);
        AuthorizationPage.timeout(driver, 3);

        AuthorizationPage.element = driver.findElement(AuthorizationPage.EMAILEXPATH);
        AuthorizationPage.element.sendKeys("");
        AuthorizationPage.element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        AuthorizationPage.element.sendKeys("");
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        assertFalse(SecondPage.isPageDisplay(driver));
        AuthorizationPage.timeout(driver, 3);

        assertTrue(driver.findElement(AuthorizationPage.ERROR_MASSAGE).isDisplayed());
    }
}

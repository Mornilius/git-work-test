package Pages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Pages.TestSecondPage.driver;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static Pages.AuthorizationPage.*;


public class TestPageAuthorization {
    AuthorizationPage datatest = new AuthorizationPage();

    @BeforeTest
    public static void startSetup(){
        driver.get(WEBSITE);
        timeout(driver,3);
    }
    @Test
    public void correctInput() {
        element = driver.findElement(EMAILEXPATH);
        element.sendKeys(AuthorizationPage.USEREMAIL);
        element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        element.sendKeys(AuthorizationPage.USERPASSWORD);
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        timeout(driver,3);
        assertTrue(SecondPage.isPageDisplay(driver));
    }
    @Test
    public void incorrectData() {
        element = driver.findElement(AuthorizationPage.EMAILEXPATH);
        element.sendKeys("dsd");
        element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        element.sendKeys("wwww");
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        assertFalse(SecondPage.isPageDisplay(driver));
        timeout(driver,3);
        assertTrue(driver.findElement(AuthorizationPage.ERROR_MASSAGE).isDisplayed());
    }@Test
    public void incorrectPassword() {
        element = driver.findElement(AuthorizationPage.EMAILEXPATH);
        element.sendKeys(AuthorizationPage.USEREMAIL);
        element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        element.sendKeys("wwww");
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        assertFalse(SecondPage.isPageDisplay(driver));
        timeout(driver,3);
        assertTrue(driver.findElement(AuthorizationPage.ERROR_MASSAGE).isDisplayed());
    }@Test
    public void incorrectEmail() {
        element = driver.findElement(AuthorizationPage.EMAILEXPATH);
        element.sendKeys("AuthorizationPage.USEREMAIL");
        element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        element.sendKeys(AuthorizationPage.USERPASSWORD);
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        assertFalse(SecondPage.isPageDisplay(driver));
        timeout(driver,3);
        assertTrue(driver.findElement(AuthorizationPage.ERROR_MASSAGE).isDisplayed());
    }@Test
    public void emptyEmailPassword() {
        element = driver.findElement(AuthorizationPage.EMAILEXPATH);
        element.sendKeys("");
        element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        element.sendKeys("");
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        assertFalse(SecondPage.isPageDisplay(driver));
        timeout(driver, 3);
        assertTrue(driver.findElement(AuthorizationPage.ERROR_MASSAGE).isDisplayed());
    }
}

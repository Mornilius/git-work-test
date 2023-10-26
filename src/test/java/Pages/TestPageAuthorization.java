package Pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.TestSecondPage.driver;

import static Pages.AuthorizationPage.*;


public class TestPageAuthorization {
    @BeforeMethod
    public static void startSetup(){
        driver.get(WEBSITE);
    }
    @Test
    public static void incorrectData(){
        clickOnInteractiveElement(driver, EMAILEXPATH);
        sendText("ddd");
        clickOnInteractiveElement(driver, PASSWORDEXPATH);
        sendText("ddd");
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);
        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed());
    }
    @Test
    public void incorrectPassword(){
        clickOnInteractiveElement(driver, EMAILEXPATH);
        sendText(USEREMAIL);
        clickOnInteractiveElement(driver, PASSWORDEXPATH);
        sendText("ddd");
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);
        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed());
    }@Test
    public void incorrectEmail(){
        clickOnInteractiveElement(driver, EMAILEXPATH);
        sendText("dd");
        clickOnInteractiveElement(driver, PASSWORDEXPATH);
        sendText(USERPASSWORD);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);
        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed());
    }@Test
    public void emptyEmailPassword(){
        clickOnInteractiveElement(driver, EMAILEXPATH);
        sendText("");
        clickOnInteractiveElement(driver, PASSWORDEXPATH);
        sendText("");
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);
        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed());
    }@Test
    public void correctInput(){
        clickOnInteractiveElement(driver, EMAILEXPATH);
        sendText(USEREMAIL);
        clickOnInteractiveElement(driver, PASSWORDEXPATH);
        sendText(USERPASSWORD);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);
        Assert.assertTrue(SecondPage.isPageDisplay(driver));
    }
}
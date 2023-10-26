package Pages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.TestSecondPage.driver;

import static Pages.AuthorizationPage.*;


public class TestPageAuthorization {
    @BeforeMethod
    public static void startSetup(){
        driver.get(WEBSITE);
        timeout(driver,3);
    }
    @Test
    public static void incorrectData(){
        sendText(driver, "ddd", EMAILEXPATH);
        sendText(driver, "ddd", PASSWORDEXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed());
    }
    @Test
    public void incorrectPassword(){
        sendText(driver, USEREMAIL, EMAILEXPATH);
        sendText(driver, "ddd", PASSWORDEXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed());
    }@Test
    public void incorrectEmail(){
        sendText(driver, "dd", EMAILEXPATH);
        sendText(driver, USERPASSWORD, PASSWORDEXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed());
    }@Test
    public void emptyEmailPassword(){
        sendText(driver, "", EMAILEXPATH);
        sendText(driver, "", PASSWORDEXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed());
    }@Test
    public void correctInput(){
        sendText(driver, USEREMAIL, EMAILEXPATH);
        sendText(driver, USERPASSWORD, PASSWORDEXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);

        Assert.assertTrue(SecondPage.isPageDisplay(driver));
    }

    @AfterTest
    public static void endTest(){
        driver.quit();
    }
}
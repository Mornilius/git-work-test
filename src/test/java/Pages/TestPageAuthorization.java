package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Pages.TestSecondPage.driver;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static Pages.AuthorizationPage.*;


public class TestPageAuthorization {

    @BeforeMethod
    public static void startSetup(){
        driver.get(WEBSITE);
        /*timeout(driver,3);*/
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
    /*@Test
    public void incorrectPassword() {
        element = driver.findElement(EMAILEXPATH);
        element.sendKeys(USEREMAIL);
        element = driver.findElement(PASSWORDEXPATH);
        element.sendKeys("wwww");
        datatest.clickOnInteractiveElement(driver, BTN_INPUT);
        assertFalse(SecondPage.isPageDisplay(driver));
        timeout(driver,3);
        //assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed());
    }*/
    /*@Test
    public void incorrectData() {
        element = driver.findElement(EMAILEXPATH);
        element.sendKeys("dsd");
        element = driver.findElement(PASSWORDEXPATH);
        element.sendKeys("wwww");
        datatest.clickOnInteractiveElement(driver, BTN_INPUT);
        assertFalse(SecondPage.isPageDisplay(driver));
        timeout(driver,3);
        //assertTrue(driver.findElement(AuthorizationPage.ERROR_MASSAGE).isDisplayed());
    }*/
    /*@Test
    public void emptyEmailPassword1() {
        element = driver.findElement(AuthorizationPage.EMAILEXPATH);
        element.sendKeys("");
        element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        element.sendKeys("");
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        assertFalse(SecondPage.isPageDisplay(driver));
        timeout(driver, 3);
        //assertTrue(driver.findElement(AuthorizationPage.ERROR_MASSAGE).isDisplayed());
    }*/
    /*@Test
    public void correctInput1() {
        element = driver.findElement(EMAILEXPATH);
        element.sendKeys(AuthorizationPage.USEREMAIL);
        element = driver.findElement(AuthorizationPage.PASSWORDEXPATH);
        element.sendKeys(AuthorizationPage.USERPASSWORD);
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
        timeout(driver,3);
        //assertTrue(SecondPage.isPageDisplay(driver));
    }*/
}
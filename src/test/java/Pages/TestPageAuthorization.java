package Pages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.UtilitsAndConst.driver;

import static Pages.AuthorizationPage.*;
import static Pages.UtilitsAndConst.*;


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

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed(), "введите некорректные данные");
    }
    @Test
    public void incorrectPassword(){
        sendText(driver, USEREMAIL, EMAILEXPATH);
        sendText(driver, "ddd", PASSWORDEXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed(), "введите некорректный пароль с корректным емаил");
    }@Test
    public void incorrectEmail(){
        sendText(driver, "dd", EMAILEXPATH);
        sendText(driver, USERPASSWORD, PASSWORDEXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed(), "введите некорректный емаил с корректным паролем");
    }@Test
    public void emptyEmailPassword(){
        sendText(driver, "", EMAILEXPATH);
        sendText(driver, "", PASSWORDEXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed(), "оставьте поля 'email' и 'пароль' пустыми");
    }@Test
    public void correctInput(){
        sendText(driver, USEREMAIL, EMAILEXPATH);
        sendText(driver, USERPASSWORD, PASSWORDEXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, 3);

        Assert.assertTrue(SecondPage.isPageDisplay(driver), "введите корректные даные во все поля для перехода на следующую страницу");
    }

    @AfterTest
    public static void endTest(){
        driver.quit();
    }
}
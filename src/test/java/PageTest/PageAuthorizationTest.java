package PageTest;

import Pages.SecondPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.AuthorizationPage.EMAIL_EXPATH;
import static Pages.AuthorizationPage.PASSWORD_EXPATH;
import static Pages.AuthorizationPage.BTN_INPUT;
import static Pages.AuthorizationPage.ERROR_MASSAGE;
import static Pages.AuthorizationPage.USER_EMAIL;
import static Pages.AuthorizationPage.USER_PASSWORD;
import static Utils.WebDriverUtils.*;


public class PageAuthorizationTest {

    @BeforeMethod
    public static void startSetup(){
        startBrowser(WEBSITE);
        timeout(driver, TIME_SECONDS);
    }

    @Test
    public static void incorrectData(){
        sendText(driver, "ddd", EMAIL_EXPATH);
        sendText(driver, "www", PASSWORD_EXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, TIME_SECONDS);

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed(), MESSAGE_ALERT_NOT_OPEN);
    }

    @Test
    public void incorrectPassword(){
        sendText(driver, USER_EMAIL, EMAIL_EXPATH);
        sendText(driver, "fff", PASSWORD_EXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, TIME_SECONDS);

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed(), MESSAGE_ALERT_NOT_OPEN);
    }

    @Test
    public void incorrectEmail(){
        sendText(driver, "dd", EMAIL_EXPATH);
        sendText(driver, USER_PASSWORD, PASSWORD_EXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, TIME_SECONDS);

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed(), MESSAGE_ALERT_NOT_OPEN);
    }

    @Test
    public void emptyEmailPassword(){
        sendText(driver, "", EMAIL_EXPATH);
        sendText(driver, "", PASSWORD_EXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, TIME_SECONDS);

        Assert.assertTrue(driver.findElement(ERROR_MASSAGE).isDisplayed(), MESSAGE_ALERT_NOT_OPEN);
    }

    @Test
    public void correctInput(){
        sendText(driver, USER_EMAIL, EMAIL_EXPATH);
        sendText(driver, USER_PASSWORD, PASSWORD_EXPATH);
        clickOnInteractiveElement(driver,BTN_INPUT);
        timeout(driver, TIME_SECONDS);

        Assert.assertTrue(SecondPage.isPageDisplay(), "Не открылась страница с добавлением пользователей");
    }

    @AfterTest
    public static void endTest(){
        driver.quit();
    }
}
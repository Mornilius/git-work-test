package PageTest;

import Pages.SecondPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


import static Pages.AuthorizationPage.EMAIL_EXPATH;
import static Pages.AuthorizationPage.USER_EMAIL;
import static Pages.AuthorizationPage.PASSWORD_EXPATH;
import static Pages.AuthorizationPage.USER_PASSWORD;
import static Pages.AuthorizationPage.BTN_INPUT;
import static Pages.SecondPage.TABLE_EMAIL_TD_LOCATOR;
import static Pages.SecondPage.TABLE_NAME_TD_LOCATOR;
import static Pages.SecondPage.TABLE_SEX_TD_LOCATOR;
import static Pages.SecondPage.TABLE_CHCKBOX_TD_LOCATOR;
import static Pages.SecondPage.TABLE_RDBTN_TD_LOCATOR;
import static Pages.SecondPage.EMAIL_LOCATOR;
import static Pages.SecondPage.NAME_LOCATOR;
import static Pages.SecondPage.ALLERT_HOLDER;
import static Utils.WebDriverUtils.*;


public class SecondPageTest {

    public static String email = "test@mail.ru";
    public static String name = "TEST";
    public static String woman = "Женский";
    public static String man = "Мужской";
    public static String chckBx1 = "1.1";
    public static String chckBx2 = "1.2";
    public static String rdBtn21 = "2.1";
    public static String rdBtn22 = "2.2";
    public static String rdBtn23 = "2.3";

    @BeforeMethod
    public static void startWork(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        startBrowser(WEBSITE);
        clickOnInteractiveElement(driver,EMAIL_EXPATH);
        sendText(driver,USER_EMAIL,EMAIL_EXPATH);
        clickOnInteractiveElement(driver, PASSWORD_EXPATH);
        sendText(driver,USER_PASSWORD,PASSWORD_EXPATH);
        clickOnInteractiveElement(driver, BTN_INPUT);
    }

    @Test
    public static void correctData(){
        timeout(driver, TIME_SECONDS);
        sendText(driver, email,EMAIL_LOCATOR);
        sendText(driver, name, NAME_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.SEX_LOCATOR_WOMAN);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_TWO_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.RADIOBTN_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.BTN_LOCATOR);
        timeout(driver, TIME_SECONDS);

        Assert.assertTrue(driver.findElement(SecondPage.MODAL_DIALOG).isDisplayed());

        clickOnInteractiveElement(driver, SecondPage.BUTTON_OK_MODAL_DIALOG);

        Assert.assertEquals(driver.findElement(TABLE_EMAIL_TD_LOCATOR).getText(), email, "актуальный или ожидаемый емаил некорректен");
        Assert.assertEquals(driver.findElement(TABLE_NAME_TD_LOCATOR).getText(), name, "актуальное или ожидаемое имя некорректно");
        Assert.assertEquals(driver.findElement(TABLE_SEX_TD_LOCATOR).getText(), woman,"некорректный выбор актуального или ожидаемого пола");
        Assert.assertEquals(driver.findElement(TABLE_CHCKBOX_TD_LOCATOR).getText(), chckBx1 +", " + chckBx2, "некорректный выбор чекбоксов");
        Assert.assertEquals(driver.findElement(TABLE_RDBTN_TD_LOCATOR).getText(), rdBtn21, "актуальный или ожидаемый выбор radio button некорректен");

    }

    @Test
    public static void inCorrectData(){
        timeout(driver, TIME_SECONDS);
        sendText(driver, "email", EMAIL_LOCATOR);
        sendText(driver, "name", NAME_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.SEX_LOCATOR_WOMAN);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_TWO_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.RADIOBTN_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.BTN_LOCATOR);
        timeout(driver, TIME_SECONDS);

        Assert.assertTrue(driver.findElement(ALLERT_HOLDER).isDisplayed(), MESSAGE_ALERT_NOT_OPEN);
    }

    @Test
    public static void emptyName(){
        timeout(driver, TIME_SECONDS);
        sendText(driver, email, EMAIL_LOCATOR);
        sendText(driver, "", NAME_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.SEX_LOCATOR_WOMAN);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_TWO_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.RADIOBTN_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.BTN_LOCATOR);
        timeout(driver, TIME_SECONDS);

        Assert.assertTrue(driver.findElement(ALLERT_HOLDER).isDisplayed(), MESSAGE_ALERT_NOT_OPEN);
    }

    @AfterTest
    public static void driverQuit(){
        driver.quit();
    }
}

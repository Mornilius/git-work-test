package Pages;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static Pages.AuthorizationPage.*;
import static Pages.SecondPage.*;
import static Pages.UtilitsAndConst.*;


public class TestSecondPage {
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
        startBrowser(driver, WEBSITE);
        clickOnInteractiveElement(driver,EMAILEXPATH);
        sendText(driver,USEREMAIL,EMAILEXPATH);
        clickOnInteractiveElement(driver, PASSWORDEXPATH);
        sendText(driver,USERPASSWORD,PASSWORDEXPATH);
        clickOnInteractiveElement(driver, BTN_INPUT);
    }

    @Test
    public static void correctData(){
        timeout(driver, 3);

        sendText(driver, email,EMAIL_LOCATOR);
        sendText(driver, name, NAME_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.SEX_LOCATOR_WOMAN);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_TWO_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.RADIOBTN_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.BTN_LOCATOR);
        timeout(driver, 2);

        Assert.assertTrue(driver.findElement(SecondPage.MODAL_DIALOG).isDisplayed());

        clickOnInteractiveElement(driver, SecondPage.BUTTON_OK_MODAL_DIALOG);

        Assert.assertEquals(driver.findElement(TABLE_EMAIL_TD_LOCATOR).getText(), email, "актуальный или ожидаемый емаил некорректен"); //актуальный результат | ожидаемый результат
        Assert.assertEquals(driver.findElement(TABLE_NAME_TD_LOCATOR).getText(), name, "актуальное или ожидаемое имя некорректно");
        Assert.assertEquals(driver.findElement(TABLE_SEX_TD_LOCATOR).getText(), woman,"некорректный выбор актуального или ожидаемого пола");
        Assert.assertEquals(driver.findElement(TABLE_CHCKBOX_TD_LOCATOR).getText(), chckBx1 +", " + chckBx2, "некорректный выбор чекбоксов");
        Assert.assertEquals(driver.findElement(TABLE_RDBTN_TD_LOCATOR).getText(), rdBtn21, "актуальный или ожидаемый выбор radio button некорректен");

    }@Test
    public static void inCorrectData(){
        timeout(driver, 3);

        sendText(driver, "email", EMAIL_LOCATOR);
        sendText(driver, "name", NAME_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.SEX_LOCATOR_WOMAN);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_TWO_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.RADIOBTN_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.BTN_LOCATOR);
        timeout(driver, 2);

        Assert.assertTrue(driver.findElement(ALLERT_HOLDER).isDisplayed(), "требуется ввести невалидные данные");// сообщение об ошибке ввода данных
    }@Test
    public static void emptyName(){
        timeout(driver, 3);
        sendText(driver, email, EMAIL_LOCATOR);
        sendText(driver, "", NAME_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.SEX_LOCATOR_WOMAN);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.CHECKBOX_TWO_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.RADIOBTN_ONE_LOCATOR);
        clickOnInteractiveElement(driver, SecondPage.BTN_LOCATOR);
        timeout(driver, 2);

        Assert.assertTrue(driver.findElement(ALLERT_HOLDER).isDisplayed(), "требуется оставить поле 'name' пустым");
    }

    @AfterTest
    public static void driverQuit(){
        driver.quit();
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSecondPage {
    public static FirefoxDriver driver = new FirefoxDriver();
    public static void startWork(){
        AuthorizationPage datatest = new AuthorizationPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        datatest.startBrowser(driver, AuthorizationPage.WEBSITE);
        datatest.clickOnInteractiveElement(driver,AuthorizationPage.EMAILEXPATH);
        datatest.sendText(AuthorizationPage.USEREMAIL);
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.PASSWORDEXPATH);
        datatest.sendText(AuthorizationPage.USERPASSWORD);
        datatest.clickOnInteractiveElement(driver, AuthorizationPage.BTN_INPUT);
    }

    @Test
    public static void correctData(){
        startWork();
        AuthorizationPage.timeout(driver, 3);
        SecondPage.sendText(driver,SecondPage.EMAIL_LOCATOR, "test@mail.ru");
        SecondPage.sendText(driver, SecondPage.NAME_LOCATOR, "TEST");
        SecondPage.clickOnActiveElements(driver, SecondPage.SEX_LOCATOR_WOMAN);
        SecondPage.clickOnActiveElements(driver, SecondPage.CHECKBOX_ONE_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.CHECKBOX_TWO_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.RADIOBTN_ONE_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.BTN_LOCATOR);
        Assert.assertTrue(driver.findElement(SecondPage.MODAL_DIALOG).isDisplayed());
    }

}

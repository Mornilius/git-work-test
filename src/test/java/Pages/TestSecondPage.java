package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import static Pages.AuthorizationPage.*;


public class TestSecondPage {
    public static WebDriver driver = getWebDriver("firefox");
    public static String email = "test@mail.ru";
    public static String name = "TEST";
    public static String woman = "Женский";
    public static String man = "Мужской";
    public static double chckBx1 = Double.parseDouble("1.1");
    public static double chckBx2 = Double.parseDouble("1.2");
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

        SecondPage.sendText(driver,SecondPage.EMAIL_LOCATOR, email);
        SecondPage.sendText(driver, SecondPage.NAME_LOCATOR, name);
        SecondPage.clickOnActiveElements(driver, SecondPage.SEX_LOCATOR_WOMAN);
        SecondPage.clickOnActiveElements(driver, SecondPage.CHECKBOX_ONE_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.CHECKBOX_TWO_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.RADIOBTN_ONE_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.BTN_LOCATOR);
        timeout(driver, 2);

        Assert.assertTrue(driver.findElement(SecondPage.MODAL_DIALOG).isDisplayed());

        SecondPage.clickOnActiveElements(driver, SecondPage.BUTTON_OK_MODAL_DIALOG);

        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='dataTable']//td[1]")).getText(), email); //актуальный результат | ожидаемый результат
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='dataTable']//td[2]")).getText(), name);
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='dataTable']//td[3]")).getText(), woman);
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='dataTable']//td[4]")).getText(), chckBx1 +"," + " " + chckBx2); //String format
        Assert.assertEquals(driver.findElement(By.xpath("//table[@id='dataTable']//td[5]")).getText(), rdBtn21);

    }@Test
    public static void inCorrectData(){
        timeout(driver, 3);

        SecondPage.sendText(driver,SecondPage.EMAIL_LOCATOR, "email");
        SecondPage.sendText(driver, SecondPage.NAME_LOCATOR, "name");
        SecondPage.clickOnActiveElements(driver, SecondPage.SEX_LOCATOR_WOMAN);
        SecondPage.clickOnActiveElements(driver, SecondPage.CHECKBOX_ONE_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.CHECKBOX_TWO_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.RADIOBTN_ONE_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.BTN_LOCATOR);
        timeout(driver, 2);

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='dataAlertsHolder']")).isDisplayed(), "ddddddd");// ко всем асертам месседжи
        //проверить, что не добавилось вообще
    }@Test
    public static void emptyName(){
        timeout(driver, 3);
        SecondPage.sendText(driver,SecondPage.EMAIL_LOCATOR, email);
        SecondPage.sendText(driver, SecondPage.NAME_LOCATOR, "");
        SecondPage.clickOnActiveElements(driver, SecondPage.SEX_LOCATOR_WOMAN);
        SecondPage.clickOnActiveElements(driver, SecondPage.CHECKBOX_ONE_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.CHECKBOX_TWO_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.RADIOBTN_ONE_LOCATOR);
        SecondPage.clickOnActiveElements(driver, SecondPage.BTN_LOCATOR);
        timeout(driver, 2);

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='dataAlertsHolder']")).isDisplayed());
        //проверить, что не добавилось вообще
    }

    @AfterTest
    public static void driverQuit(){
        driver.quit();
    }
}

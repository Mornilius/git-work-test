package Pages;
import org.openqa.selenium.By;

import static Utils.WebDriverUtils.driver;


public class SecondPage {

    public static final By EMAIL_LOCATOR = By.xpath("//input[@id='dataEmail']");
    public static final By NAME_LOCATOR = By.xpath("//input[@id='dataName']");
    public static final By SEX_LOCATOR = By.xpath("//select[@id='dataGender']");
    public static final By SEX_LOCATOR_MAN = By.xpath("//option[text()='Мужской']");
    public static final By SEX_LOCATOR_WOMAN = By.xpath("//option[text()='Женский']");
    public static final By CHECKBOX_ONE_LOCATOR = By.xpath("//input[@id='dataCheck11']");
    public static final By CHECKBOX_TWO_LOCATOR = By.xpath("//input[@id='dataCheck12']");
    public static final By RADIOBTN_ONE_LOCATOR = By.xpath("//input[@id='dataSelect21']");
    public static final By RADIOBTN_TWO_LOCATOR = By.xpath("//input[@id='dataSelect22']");
    public static final By RADIOBTN_THREE_LOCATOR = By.xpath("//input[@id='dataSelect23']");
    public static final By BTN_LOCATOR = By.xpath("//button[@id='dataSend']");
    public static final String TABLE_STRING = "//table[@id='dataTable']%s";
    public static final By TABLE_EMAIL_LOCATOR = By.xpath(String.format(TABLE_STRING, "//th[text()='E-Mail']"));
    public static final By TABLE_NAME_LOCATOR = By.xpath(String.format(TABLE_STRING, "//th[text()='Имя']"));
    public static final By TABLE_SEX_LOCATOR = By.xpath(String.format(TABLE_STRING, "//th[text()='Пол']"));
    public static final By TABLE_VAR1_LOCATOR = By.xpath(String.format(TABLE_STRING, "//th[text()='Выбор 1']"));
    public static final By TABLE_VAR2_LOCATOR = By.xpath(String.format(TABLE_STRING, "//th[text()='Выбор 2']"));
    public static final By TABLE_EMAIL_TD_LOCATOR = By.xpath(String.format(TABLE_STRING, "//td[1]"));
    public static final By TABLE_NAME_TD_LOCATOR = By.xpath(String.format(TABLE_STRING, "//td[2]"));
    public static final By TABLE_SEX_TD_LOCATOR = By.xpath(String.format(TABLE_STRING, "//td[3]"));
    public static final By TABLE_CHCKBOX_TD_LOCATOR = By.xpath(String.format(TABLE_STRING, "//td[4]"));
    public static final By TABLE_RDBTN_TD_LOCATOR = By.xpath(String.format(TABLE_STRING, "//td[5]"));
    public static final By MODAL_DIALOG = By.xpath("//div[@class='uk-modal-dialog']");
    public static final By BUTTON_OK_MODAL_DIALOG = By.xpath("//button[@class='uk-button uk-button-primary uk-modal-close']");
    public static final By ALLERT_HOLDER = By.xpath("//div[@id='dataAlertsHolder']");

    public static boolean isPageDisplay(){
        return driver.findElement(EMAIL_LOCATOR).isDisplayed()&
        driver.findElement(NAME_LOCATOR).isDisplayed()&
        driver.findElement(SEX_LOCATOR).isDisplayed()&
        driver.findElement(CHECKBOX_ONE_LOCATOR).isDisplayed()&
        driver.findElement(CHECKBOX_TWO_LOCATOR).isDisplayed()&
        driver.findElement(RADIOBTN_ONE_LOCATOR).isDisplayed()&
        driver.findElement(RADIOBTN_TWO_LOCATOR).isDisplayed()&
        driver.findElement(RADIOBTN_THREE_LOCATOR).isDisplayed()&
        driver.findElement(BTN_LOCATOR).isDisplayed()&
        driver.findElement(TABLE_EMAIL_LOCATOR).isDisplayed()&
        driver.findElement(TABLE_NAME_LOCATOR).isDisplayed()&
        driver.findElement(TABLE_SEX_LOCATOR).isDisplayed()&
        driver.findElement(TABLE_VAR1_LOCATOR).isDisplayed()&
        driver.findElement(TABLE_VAR2_LOCATOR).isDisplayed();
    }
}
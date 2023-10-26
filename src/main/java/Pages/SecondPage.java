package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SecondPage {
    public static final By EMAIL_LOCATOR = By.xpath("//input[@id='dataEmail']");
    public static final By NAME_LOCATOR = By.xpath("//input[@id='dataName']");
    public static final By SEX_LOCATOR = By.xpath("//select[@id='dataGender']%s");
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
    public static final By MODAL_DIALOG = By.xpath("//div[@class='uk-modal-dialog']");
    public static final By BUTTON_OK_MODAL_DIALOG = By.xpath("//button[@class='uk-button uk-button-primary uk-modal-close']");

    public static boolean isPageDisplay(WebDriver driver){
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

    public static void clickOnActiveElements(FirefoxDriver driver, By locator){
        driver.findElement(locator).click();
    }
    public static void sendText(FirefoxDriver driver, By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
}

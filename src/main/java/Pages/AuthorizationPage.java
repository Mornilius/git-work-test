package Pages;

import org.openqa.selenium.By;


public class AuthorizationPage {

    public static final By EMAIL_EXPATH = By.xpath("//input[@id='loginEmail']");
    public static final By PASSWORD_EXPATH = By.xpath("//input[@id='loginPassword']");
    public static final By ERROR_MASSAGE = By.xpath("//div[@id='authAlertsHolder']");
    public static final By BTN_INPUT = By.xpath("//button[@id='authButton']");
    public static final String USER_EMAIL = "test@protei.ru";
    public static final String USER_PASSWORD = "test";
}







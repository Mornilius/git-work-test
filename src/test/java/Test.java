import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
    FirefoxDriver driver = new FirefoxDriver();
    @org.testng.annotations.Test
    void startBrowserTest(){
        driver.get(DataTest.Website);
    }
    @org.testng.annotations.Test
    void clickAndSendEmail(){
        startBrowserTest();
        DataTest.element = driver.findElement(By.xpath(DataTest.EMAILEXPATH));
        DataTest.element.click();
        DataTest.element.sendKeys(DataTest.USEREMAIL);
    }
    @org.testng.annotations.Test
    void clickAndSendPassword(){
        startBrowserTest();
        DataTest.element = driver.findElement(By.xpath(DataTest.PASSWORDEXPATH));
        DataTest.element.click();
        DataTest.element.sendKeys(DataTest.USERPASSWORD);
    }
}

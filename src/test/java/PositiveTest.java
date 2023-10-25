import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PositiveTest {
    FirefoxDriver driver = new FirefoxDriver();
    DataTest datatest = new DataTest();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    @Test
    public void correctInput() throws InterruptedException {
        driver.get(DataTest.Website);
        Thread.sleep(2000);
        DataTest.element = driver.findElement(By.xpath(DataTest.EMAILEXPATH));
        DataTest.element.click();
        DataTest.element.sendKeys(DataTest.USEREMAIL);
        DataTest.element = driver.findElement(By.xpath(DataTest.PASSWORDEXPATH));
        DataTest.element.click();
        DataTest.element.sendKeys(DataTest.USERPASSWORD);
        datatest.clickOnTop(driver, "//button[@id='authButton']");
        /*wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='dataSend'")));*/
        driver.quit();
    }
    @Test
    public void waitAllert() throws InterruptedException {
        driver.get(DataTest.Website);
        Thread.sleep(2000);
        DataTest.element = driver.findElement(By.xpath(DataTest.EMAILEXPATH));
        DataTest.element.click();
        DataTest.element.sendKeys("dsd");
        DataTest.element = driver.findElement(By.xpath(DataTest.PASSWORDEXPATH));
        DataTest.element.click();
        DataTest.element.sendKeys("wwww");
        datatest.clickOnTop(driver, "//button[@id='authButton']");
        /*wait.until(ExpectedConditions.alertIsPresent());*/
        driver.quit();
    }
}

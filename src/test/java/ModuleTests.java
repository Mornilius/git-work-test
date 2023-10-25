import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class ModuleTests {
    FirefoxDriver driver = new FirefoxDriver();
    @org.testng.annotations.Test
    void startBrowserTest(){
        driver.get(DataTest.Website);
        Assert.assertEquals();
    }
    @org.testng.annotations.Test
    void clickAndSendEmail() throws InterruptedException {
        startBrowserTest();
        Thread.sleep(5000);
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

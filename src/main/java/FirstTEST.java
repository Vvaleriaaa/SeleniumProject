import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class FirstTEST {


    @Test
    void checkSomething(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By code = By.xpath("//button[@data-qa-node='phone-code']");
        By phoneNamber = By.xpath("//input[@data-qa-node='phone-number']");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        By money = By.xpath("//input[@data-qa-node='amount']");
        By cardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By submitBtn = By.xpath("//button[@type='submit']");



        driver.get("https://next.privat24.ua/mobile");
        driver.findElement(By.xpath("//button[@data-qa-node='phone-code']"));
        driver.findElement(phoneNamber).sendKeys("675679744");
        driver.findElement(amount).sendKeys(Keys.CONTROL+"A");
        driver.findElement(money).sendKeys("212");
        driver.findElement(cardFrom).sendKeys("4004159115449003");
        driver.findElement(expDate).sendKeys("1122");
        driver.findElement(cvv).sendKeys("222");
        driver.findElement(submitBtn).submit();



        By expepectedCardFrom = By.xpath("//td[@data-qa-node='card']");
        By expepectedCategory = By.xpath("//div[@data-qa-node='category']");
        By expepectedDetails = By.xpath("//div[@data-qa-node='details']");
        By expepectedNameB = By.xpath("//span[@data-qa-node='nameB']");
        By expepectedAmount = By.xpath("//div[@data-qa-node='amount']");
        Assertions.assertEquals("4004 **** **** 9003", driver.findElement(expepectedCardFrom).getText());
        Assertions.assertEquals("???????????????????? ????????????????????", driver.findElement(expepectedCategory).getText());
        Assertions.assertEquals("???????????????????? ????????????????. ???? ?????????? +380675679744", driver.findElement(expepectedDetails).getText());
        Assertions.assertEquals("Kyivstar Ukraine", driver.findElement(expepectedNameB).getText());
        Assertions.assertEquals("212 UAH", driver.findElement(expepectedAmount).getText());

    }
}

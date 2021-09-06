import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class writeBoxCheck {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void writeOnTextBox(){
        driver.get("https://demoqa.com/elements");
        driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).click();
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("userName"))).sendKeys("Rahim");
//        driver.findElement(By.cssSelector("[id=userName]")).sendKeys("Rahim");
        driver.findElement(By.cssSelector("#submit")).sendKeys(Keys.ENTER);
        String text= driver.findElement(By.cssSelector("[id=name]")).getText();
        Assert.assertTrue(text.contains("Rahim"));
    }

    @After
    public void finishTest() {
        driver.close();
    }

}
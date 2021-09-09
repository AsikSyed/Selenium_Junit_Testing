package seleniumJunit.test;


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

public class gmailTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        //ops.addArguments("--headed");
        ops.addArguments("--headed");//for not opening browser
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void EmailTesting() {
        driver.get("https://accounts.google.com/signin/v2/identifier?passive=1209600&continue=https%3A%2F%2Faccounts.google.com%2Fb%2F0%2FAddMailService&followup=https%3A%2F%2Faccounts.google.com%2Fb%2F0%2FAddMailService&hl=en-GB&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#identifierId"))).sendKeys("fardinaminarpon@gmail.com");
        driver.findElement(By.xpath("//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']//button[@type='button']")).sendKeys(Keys.ENTER);
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("//input[@type='password']"))).sendKeys("fardinaminarpon@gmail.com");

    }
}

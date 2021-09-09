package seleniumJunit.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class googleImageSearch {
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
    public void imagelinkSearch() {
        driver.get("https://www.google.com.bd/imghp?hl=en&tab=ri&ogbl");
        driver.findElement(By.xpath("//body/div[@id='viewport']/div[@id='searchform']/div[@id='qbc']/form[@id='tsf']/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/span[1]")).click();

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Ycyxxc']"))).sendKeys("https://i.ytimg.com/vi/1Ne1hqOXKKI/maxresdefault.jpg");

        driver.findElement(By.xpath("//input[@id='RZJ9Ub']")).sendKeys(Keys.ENTER);


    }

    @Test
    public void imageSearch() {
        driver.get("https://www.google.com.bd/imghp?hl=en&tab=ri&ogbl");
        driver.findElement(By.xpath("//body/div[@id='viewport']/div[@id='searchform']/div[@id='qbc']/form[@id='tsf']/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/span[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Upload an image')]")).click();
        //driver.findElement(By.xpath("//input[@id='awyMjb']")).click();
        WebElement uploadElement = driver.findElement(By.xpath("//input[@id='awyMjb']"));
//        uploadElement.sendKeys("./src/test/resources/cat.jpg");
//        String text = driver.findElement(By.id("uploadedFilePath")).getText();
//        Assert.assertTrue(text.contains("cat.jpg"));
        File file = new File("./src/test/resources/cat.jpg");
        driver.findElement(By.name("encoded_image")).sendKeys(file.getAbsolutePath());

        Boolean status = driver.findElement(By.xpath("//img[@class='GMzDwb']")).isDisplayed();
        Assert.assertEquals(status,true);

    }



    @After
    public void finishTest() {

        driver.close();
    }
}

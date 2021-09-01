import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;


public class gmailTest {

    WebDriver driver;

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
    public void getTitle() {
        driver.get("https://gmail.com");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains("Gmail"));
    }

    @After
    public void finishTest() {
        driver.close();
    }
}

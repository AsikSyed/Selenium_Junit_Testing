import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class multWindoCheck {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        FirefoxOptions ops=new FirefoxOptions();
        //ops.addArguments("--headed");
        ops.addArguments("--headless");//for not opening browser
        driver=new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
  public void multiwindow(){
      driver.get("https://demoqa.com/browser-windows"); driver.findElement(By.id(("windowButton"))).click();

      //Thread.sleep(5000);
      WebDriverWait wait = new WebDriverWait(driver, 5);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("windowButton")));
      String mainWindowHandle = driver.getWindowHandle();
      Set<String> allWindowHandles = driver.getWindowHandles();
      Iterator<String> iterator = allWindowHandles.iterator();
      while(iterator.hasNext())

      {
          String ChildWindow = iterator.next();
          if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
              driver.switchTo().window(ChildWindow);
              String text = driver.findElement(By.id("sampleHeading")).getText();
              Assert.assertTrue(text.contains("This is a sample page"));
          }
      }
  }

    @After
    public void finishTest() {
        driver.close();
    }
}

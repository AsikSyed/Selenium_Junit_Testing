//package seleniumJunit.test;
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//
//
//public class testMultab {
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public static class HandlingMultipleTabs {
//
//        public static void main(String[] args) throws InterruptedException, AWTException {
//            // TODO Auto-generated method stub
//
//            System.setProperty("webdriver.chrome.driver", ".\\ChromeDriver\\chromedriver.exe");
//            WebDriver driver = new ChromeDriver();
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//            //Navigating to airbnb
//            driver.get("https://www.airbnb.co.in/");
//
//            driver.manage().window().maximize();
//
//            String currentHandle = driver.getWindowHandle();
//
//            //locating the location, looking for homestays
//            driver.findElement(By.id("Koan-magic-carpet-koan-search-bar__input")).sendKeys("Goa", Keys.ENTER);
//
//            //Clicking on search button
//            driver.findElement(By.xpath("//button[@type='submit']")).click();
//            String urlToClick = driver.findElement(By.xpath("//div[text()='Luxury Three Bedroom Apartment with Pool & Jacuzzi']/ancestor::a")).getAttribute("href");
//
//            //opening the new tab
//            Robot r = new Robot();
//            r.keyPress(KeyEvent.VK_CONTROL);
//            r.keyPress(KeyEvent.VK_T);
//            r.keyRelease(KeyEvent.VK_CONTROL);
//            r.keyRelease(KeyEvent.VK_T);
//
//            //getting all the handles currently available
//            Set<String> handles = driver.getWindowHandles();
//            for (String actual : handles) {
//
//                if (!actual.equalsIgnoreCase(currentHandle)) {
//                    //switching to the opened tab
//                    driver.switchTo().window(actual);
//
//                    //opening the URL saved.
//                    driver.get(urlToClick);
//                }
//            }
//
//
//        }
//
//    }

package jsExecutor;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anna on 2018-09-13.
 */
public class JsExecutor {

    private static WebDriver driver;
    private static JavascriptExecutor js;

    @Before
    public void setuUp() throws MalformedURLException {
        /* SeleniumGrid settings
        System.setProperty("webdriver.gecko.driver","C:\\Tools\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL("http://192.168.99.1:5566/wd/hub"), capabilities);
       */
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.get("http://the-internet.herokuapp.com/");
    }


    @Test
    public void test1() {
        WebElement element = driver.findElement(By.linkText("Dropdown"));
        js.executeScript("arguments[0].click()", element);
    }

    @Test
    public void test2() throws InterruptedException {
        js.executeScript("window.scrollBy(0,300)");
    }

    @Test
    public void test3() {
        String title = js.executeScript("return document.URL").toString();
        System.out.println(title);
        assertEquals("http://the-internet.herokuapp.com/", title);
    }

    @Test
    public void test4() {
        WebElement element = driver.findElement(By.linkText("Forgot Password"));
        element.click();
        // In older browser cas cause "document.getElementsByClassName is not a function"
        js.executeScript("return document.getElementByClassName('icon-signin').click();");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

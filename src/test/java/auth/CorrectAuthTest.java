package auth;

import javafx.scene.control.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.*;

/**
 * Created by Anna on 2018-08-20.
 */
public class CorrectAuthTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void correctAuth()  {
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        String expectedText = driver.findElement(By.xpath("/html/body/div[2]/div/div/p")).getText();
        assertEquals("Congratulations! You must have the proper credentials." , expectedText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

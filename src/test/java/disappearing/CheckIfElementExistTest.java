package disappearing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SourceType;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Anna on 2018-08-21.
 */
public class CheckIfElementExistTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Disappearing Elements")).click();
    }

//    @Test
//    public void checkIfElementExist() {
//        boolean exist = isElementExist();
//        assertTrue(exist);
//    }
//
//    private boolean isElementExist() {
//        try {
//            driver.findElement(By.partialLinkText("Gallery"));
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//        return true;
//    }

    @Test
    public void checkIfElementExist2() {
        boolean exist = driver.findElements(By.linkText("Gallery")).size() != 0;
        assertTrue(exist);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}

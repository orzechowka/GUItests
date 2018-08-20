package contextMenu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static junit.framework.TestCase.assertTrue;


/**
 * Created by Anna on 2018-08-20.
 */
public class checkCustomAdditionTest {

        WebDriver driver;

        @Before
        public void setUp() {
            driver = new FirefoxDriver();
            driver.get("http://the-internet.herokuapp.com/");
        }

        @Test
        public void checkIfCheckboxIsChecked() {
            driver.findElement(By.linkText("Context Menu")).click();
            WebElement element = driver.findElement(By.id("hot-spot"));
            Actions actions = new Actions(driver);
            actions.contextClick(element).perform();

            //find a way to click option
            assertTrue(isAlertPresent());
        }

        @After
        public void tearDown() {
            driver.quit();
        }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}

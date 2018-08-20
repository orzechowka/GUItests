package checkboxes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Anna on 2018-08-20.
 */
public class CheckDefaultsCheckboxesSettingTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Test
    public void checkIfCorrectCheckboxesAreChecked() {
        driver.findElement(By.linkText("Checkboxes")).click();
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        assertFalse(checkboxes.get(0).isSelected());
        assertTrue(checkboxes.get(1).isSelected());
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}

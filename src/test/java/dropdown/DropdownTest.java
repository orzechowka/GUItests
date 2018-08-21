package dropdown;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anna on 2018-08-21.
 */
public class DropdownTest {

    WebDriver driver;
    Select select;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dropdown")).click();
        select = new Select(driver.findElement(By.id("dropdown")));

    }

    @Test
    public void chooseOptionFromSelect() {

        select.selectByVisibleText("Option 1");

        WebElement firstSelectedOption = select.getFirstSelectedOption();

        String valueOfSelectedOption = firstSelectedOption.getAttribute("value");

        assertEquals("1", valueOfSelectedOption);

    }

    @Test
    public void chooseOptionFromSelect2() {

        select.selectByValue("2");

        WebElement firstSelectedOption = select.getFirstSelectedOption();

        String valueOfSelectedOption = firstSelectedOption.getAttribute("value");

        assertEquals("2", valueOfSelectedOption);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

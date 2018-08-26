package dynamicControlsWait;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Anna on 2018-08-26.
 */
public class LookingForAnElementTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dynamic Loading")).click();
    }

    @Test
    public void checkIfElementisDisplayed() {
        driver.findElement(By.partialLinkText("Example 1")).click();

        WebElement finished = driver.findElement(By.id("finish"));
        boolean displayed = finished.isDisplayed();
        assertFalse(finished.isDisplayed());
        List<WebElement> finished1 = driver.findElements(By.id("finish"));
        assertTrue(finished1.size() > 0);

        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assertTrue(finished.isDisplayed());
    }

    @Test
    public void checkIfElementisPresented() {
        driver.findElement(By.partialLinkText("Example 2")).click();
        List<WebElement> finished1 = driver.findElements(By.id("finish"));
        assertFalse(finished1.size() > 0);

        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assertTrue(driver.findElement(By.id("finish")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

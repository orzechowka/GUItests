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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CheckIfCheckboxAppearsOrDisappearTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dynamic Controls")).click();
    }

    @Test
    public void checkIfCheckboxDisappear() {
        WebElement btn = driver.findElement(By.tagName("button"));
        btn.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        Boolean exist = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        assertTrue(exist);
        assertEquals("It's gone!",getMessage());

        btn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));

        assertEquals("It's back!", getMessage());
    }

    private String getMessage() {
        WebElement textMessage = driver.findElement(By.id("message"));
        return textMessage.getText();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

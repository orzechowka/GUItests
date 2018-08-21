package dragAndDrop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Anna on 2018-08-21.
 */
public class DragAndDropTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com");
    }

    @Test
    public void dragAndDropTest() {
        driver.findElement(By.linkText("Drag and Drop")).click();
        WebElement a = driver.findElement(By.id("column-a"));
        WebElement b = driver.findElement(By.id("column-b"));

        int x = b.getLocation().getX() - a.getLocation().getX();
        int y = b.getLocation().getY() - a.getLocation().getY();
        Actions builder = new Actions(driver);
        // not moving to specific location
        builder.clickAndHold(a).moveByOffset(x, y).build().perform();
        //builder.dragAndDropBy(a, x, y).build().perform();
       // builder.dragAndDrop(a, b).perform();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

package images;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Anna on 2018-08-20.
 */
public class BrokenImagesTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Test
    public void findBrokenImages() {
        driver.findElement(By.linkText("Broken Images")).click();
        WebElement element = driver.findElement(By.className("example"));
        List<WebElement> images = element.findElements(By.tagName("img"));

        // test will fail cause images are broken
        images.forEach(img -> assertNotEquals(0, Integer.parseInt(img.getAttribute("naturalWidth"))));

        // assertions to check if test is proper
        // assertEquals(0, Integer.parseInt(images.get(0).getAttribute("naturalWidth")));
        // assertEquals(0, Integer.parseInt(images.get(1).getAttribute("naturalWidth")));
        // assertNotEquals(0, Integer.parseInt(images.get(2).getAttribute("naturalWidth")));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

package findByAnnotation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Anna on 2018-09-12.
 */
public class FindByTest extends TestBase {

    //private static WebDriver driver = new FirefoxDriver();

    @FindBy(linkText = "Typos")
    private static WebElement typosLink;

    public static void goToTypos() {
        PageFactory.initElements(driver, FindByTest.class);
        typosLink.click();
        String example = driver.findElement(By.className("example")).getText();
        assertTrue(example.contains("Typos"));
    }

    @Test
    public void test() {
        goToTypos();
    }
}

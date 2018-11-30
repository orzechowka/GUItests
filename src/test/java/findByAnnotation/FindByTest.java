package findByAnnotation;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anna on 2018-09-12.
 */
public class FindByTest {

    private static WebDriver driver = new FirefoxDriver();

    @FindBy(linkText = "Typos")
    private static WebElement typosLink;

    public static void goToTypos() {
        driver.get("http://the-internet.herokuapp.com/");
        PageFactory.initElements(driver, FindByTest.class);
        typosLink.click();
    }

    @Test
    public void test() {
        goToTypos();
    }
}

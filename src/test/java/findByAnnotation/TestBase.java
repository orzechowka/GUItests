package findByAnnotation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/");
    }

    @AfterClass
    public static void tearDow() {
        driver.quit();
    }
}

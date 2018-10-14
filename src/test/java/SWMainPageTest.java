import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
public class SWMainPageTest {
    private WebDriver driver;
    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void testEasy() {
        driver.get("https://www.starwars.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("The Official Star Wars Website"));
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}

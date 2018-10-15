package tests;

import helpers.components.BaseElement;
import helpers.pages.BasePage;
import helpers.pages.SWMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SWMainPageTest {
    private WebDriver driver;
    private SWMainPage mainPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        BaseElement.setDriver(driver);
        BasePage.setDriver(driver);
        mainPage = new SWMainPage();
    }

    @Test(priority = 1)
    public void testPageLoads() {
        mainPage.visit();
        Assert.assertTrue(mainPage.isCurrentPage());
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 2)
    public void testPageTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("The Official Star Wars Website"), "Actual title: " + title);
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 2)
    public void testPageElements() {
        mainPage.checkDesktopLayout();
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 3)
    public void testPageSearch() {
        Assert.assertFalse(mainPage.getSearchResultsBox().isVisible());
        mainPage.search("Jabba");
        Assert.assertTrue(mainPage.getSearchResultsBox().isVisible());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

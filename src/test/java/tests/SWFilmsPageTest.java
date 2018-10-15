package tests;

import helpers.components.BaseElement;
import helpers.pages.BaseSWPage;
import helpers.pages.SWFilmsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SWFilmsPageTest {
    private WebDriver driver;
    private SWFilmsPage filmsPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        BaseElement.setDriver(driver);
        BaseSWPage.setDriver(driver);
        filmsPage = new SWFilmsPage();
    }

    @Test(priority = 1)
    public void testPageLoads() {
        filmsPage.visit();
        Assert.assertTrue(filmsPage.isCurrentPage());
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 2)
    public void testPageTitle() {
        String title = driver.getTitle();
        System.out.printf("Title of page: %s\n", title);
        Assert.assertTrue(title.contains("Star Wars Movies"), "Actual title: " + title);
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 2)
    public void testPageElements() {
        List<BaseElement> expectedElements = filmsPage.getExpectedDesktopLayout();
        for (BaseElement elem : expectedElements) {
            Assert.assertTrue(elem.isVisible());
        }
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 3)
    public void testPageSearch() {
        Assert.assertFalse(filmsPage.getSearchResultsBox().isVisible());
        filmsPage.search("Jabba");
        Assert.assertTrue(filmsPage.getSearchResultsBox().isVisible());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

package tests;

import helpers.components.BaseElement;
import helpers.pages.BaseSWPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SWPagesSmokeTest {
    private WebDriver driver;
    private BaseSWPage page;

    @Parameters({"pageType"})
    @BeforeClass
    public void setup(String pageType) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        BaseElement.setDriver(driver);
        BaseSWPage.setDriver(driver);
        page = BaseSWPage.getPageInstance(pageType);
    }

    @Test(priority = 1)
    public void testPageLoads() {
        page.visit();
        Assert.assertTrue(page.isCurrentPage());
    }

    @Parameters({"expectedTitle"})
    @Test(dependsOnMethods = {"testPageLoads"}, priority = 2)
    public void testPageTitle(String expectedTitle) {
        String title = driver.getTitle();
        System.out.printf("Title of page: %s\n", title);
        Assert.assertTrue(title.contains(expectedTitle), "Actual title: " + title);
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 2)
    public void testPageElements() {
        List<BaseElement> expectedElements = page.getExpectedDesktopLayout();
        for (BaseElement elem : expectedElements) {
            Assert.assertTrue(elem.isVisible());
        }
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 3)
    public void testPageSearch() {
        Assert.assertFalse(page.getSearchResultsBox().isVisible());
        page.search("Jabba");
        Assert.assertTrue(page.getSearchResultsBox().isVisible());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

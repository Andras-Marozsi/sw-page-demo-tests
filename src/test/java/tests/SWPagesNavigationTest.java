package tests;

import helpers.components.BaseElement;
import helpers.pages.BaseSWPage;
import helpers.pages.SWFilmsPage;
import helpers.pages.SWMainPage;
import helpers.pages.SWVideoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SWPagesNavigationTest {
    private WebDriver driver;
    private BaseSWPage page;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        BaseElement.setDriver(driver);
        BaseSWPage.setDriver(driver);
        page = new SWMainPage();
    }

    @Test
    public void testPageLoads() {
        page.visit();
        Assert.assertTrue(page.isCurrentPage(), "Current page is not as expected!");
    }

    @Test(dependsOnMethods = {"testPageLoads"})
    public void testSectionsVisible() {
        Assert.assertTrue(page.getHeader().getSections().isVisible());
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 1)
    public void testNavigateToVideoPage() {
        page.getHeader().getVideoSection().click();
        page = new SWVideoPage();
        Assert.assertTrue(page.isCurrentPage(), "Current page is not as expected!");
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 2)
    public void testNavigateToFilmsPage() {
        page.getHeader().getFilmsSection().click();
        page = new SWFilmsPage();
        Assert.assertTrue(page.isCurrentPage(), "Current page is not as expected!");
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 3)
    public void testNavigateToMainPage() {
        page.getHeader().getLogo().click();
        page = new SWMainPage();
        Assert.assertTrue(page.isCurrentPage(), "Current page is not as expected!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

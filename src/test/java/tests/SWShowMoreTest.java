package tests;

import helpers.components.BaseElement;
import helpers.pages.BaseSWPage;
import helpers.pages.SWMainPage;
import helpers.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SWShowMoreTest {
    private WebDriver driver;
    private SWMainPage page;

    @BeforeClass
    public void setup() {
        System.setProperty(Constants.WEBDRIVER_PROPERTY_CHROME, Constants.WEBDRIVER_PATH_CHROME);
        driver = new ChromeDriver();
        BaseElement.setDriver(driver);
        BaseSWPage.setDriver(driver);
        page = new SWMainPage();
    }

    @Test
    public void testPageLoads() {
        page.visit();
        Assert.assertTrue(page.isCurrentPage());
    }

    @Test(dependsOnMethods = {"testPageLoads"})
    public void testShowMoreButton() {

        int initialArticleNumber = page.getDataBankSection().getNumberOfArticles();
        System.out.printf("Initial Article #: %d\n", initialArticleNumber);
        page.getDataBankSection().clickShowMore();
        int extendedArticleNumber = page.getDataBankSection().getNumberOfArticles();
        System.out.printf("Extended Article #: %d\n", extendedArticleNumber);
        Assert.assertTrue(initialArticleNumber < extendedArticleNumber, "No new articles were loaded after clicking 'ShowMore'");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

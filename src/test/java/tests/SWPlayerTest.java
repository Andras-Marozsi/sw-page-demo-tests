package tests;

import helpers.components.BaseElement;
import helpers.pages.BaseSWPage;
import helpers.pages.SWVideoPage;
import helpers.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SWPlayerTest {
    private WebDriver driver;
    private SWVideoPage page;

    @BeforeClass
    public void setup() {
        System.setProperty(Constants.WEBDRIVER_PROPERTY_CHROME, Constants.WEBDRIVER_PATH_CHROME);
        driver = new ChromeDriver();
        BaseElement.setDriver(driver);
        BaseSWPage.setDriver(driver);
        page = new SWVideoPage();
    }

    @Test
    public void testPageLoads() {
        page.visit();
        Assert.assertTrue(page.isCurrentPage());
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 1)
    public void testNoVideoPlayerOnPage() {
        Assert.assertFalse(page.getCustomPlayer().isPresent(), "Custom player shouldn't be present on page by default");
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 2)
    public void testNavigateToVideo() {
        page.clickNthArticleWithCustomPlayer(1);
    }

    @Test(dependsOnMethods = {"testPageLoads"}, priority = 3)
    public void testVideoPlayerOnPage() {
        Assert.assertTrue(page.getCustomPlayer().isPresent(), "Custom player should be present on page after clicking an article");
    }

    @Test(dependsOnMethods = {"testVideoPlayerOnPage"}, priority = 3)
    public void testAutoPlay() {
        page.waitForBackgroundCallsToFinish(Constants.TIEMOUT_IN_SEC_MEDIUM);
        Assert.assertTrue(page.getCustomPlayer().isPlaying(), "Custom player should auto play");
    }

    @Test(dependsOnMethods = {"testVideoPlayerOnPage"}, priority = 4)
    public void testPausingVideo() {
        page.getCustomPlayer().playPause();
        Assert.assertTrue(page.getCustomPlayer().isPaused(), "Custom player should pause after 1st click");
    }

    @Test(dependsOnMethods = {"testPausingVideo"}, priority = 4)
    public void testReStartingVideo() {
        page.getCustomPlayer().playPause();
        Assert.assertTrue(page.getCustomPlayer().isPlaying(), "Custom player should play after 2nd click");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

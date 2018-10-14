package helpers.components;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Helper for the Header, including search/navigation/etc.
 */
public class Header extends BaseElement {
    public BaseElement navSearch = new BaseElement(By.cssSelector("input#nav-search-input"));
    public BaseElement logo = new BaseElement(By.cssSelector("a#nav-sw-logo"));

    public BaseElement logIn = new BaseElement(By.cssSelector("div.nav-login div.disid-login"));
    public BaseElement signUp = new BaseElement(By.cssSelector("div.nav-login div.disid-signup"));

    // Social Links
    public BaseElement socialLinks = new BaseElement(By.cssSelector("ul#social-links"));
    public BaseElement facebookLink = new BaseElement(By.cssSelector("ul#social-links a[title='facebook']"));
    public BaseElement tumblrLink = new BaseElement(By.cssSelector("ul#social-links a[title='tumblr']"));
    public BaseElement twitterLink = new BaseElement(By.cssSelector("ul#social-links a[title='twitter']"));
    public BaseElement instagramLink = new BaseElement(By.cssSelector("ul#social-links a[title='instagram']"));
    public BaseElement googlePlusLink = new BaseElement(By.cssSelector("ul#social-links a[title='google plus']"));
    public BaseElement youtubeLink = new BaseElement(By.cssSelector("ul#social-links a[title='youtube']"));

    // Sections
    public BaseElement sections = new BaseElement(By.cssSelector("ul#section-links"));
    public BaseElement newsSection = new BaseElement(By.cssSelector("ul#section-links a[data-section='news']"));
    public BaseElement videoSection = new BaseElement(By.cssSelector("ul#section-links a[data-section='video']"));
    public BaseElement eventsSection = new BaseElement(By.cssSelector("ul#section-links a[data-section='events']"));
    public BaseElement filmsSection = new BaseElement(By.cssSelector("ul#section-links a[data-section='films']"));
    public BaseElement tvShowsSection = new BaseElement(By.cssSelector("ul#section-links a[data-section='tvshows']"));
    public BaseElement gamesAppsSection = new BaseElement(By.cssSelector("ul#section-links a[data-section='gamesapps']"));
    public BaseElement communitySection = new BaseElement(By.cssSelector("ul#section-links a[data-section='community']"));
    public BaseElement dataBankSection = new BaseElement(By.cssSelector("ul#section-links a[data-section='databank']"));

    /**
     * Constructor with the default base selector
     */
    public Header() {
        super(By.cssSelector("div#nav-inner-container"));
    }

    /**
     * Constructor with a custom base selector
     * @param selector custom base selector
     */
    public Header(By selector) {
        super(selector);
    }

    /**
     * Checks if all the elements that are supposed to be displayed on the {desktop} layout ar visible
     */
    public void checkDesktopLayout() {
        Assert.assertTrue(navSearch.isVisible());
        Assert.assertTrue(logo.isVisible());
        Assert.assertTrue(logIn.isVisible());
        Assert.assertTrue(signUp.isVisible());
        Assert.assertTrue(socialLinks.isVisible());
        Assert.assertTrue(facebookLink.isVisible());
        Assert.assertTrue(tumblrLink.isVisible());
        Assert.assertTrue(twitterLink.isVisible());
        Assert.assertTrue(instagramLink.isVisible());
        Assert.assertTrue(googlePlusLink.isVisible());
        Assert.assertTrue(youtubeLink.isVisible());
        Assert.assertTrue(sections.isVisible());
        Assert.assertTrue(newsSection.isVisible());
        Assert.assertTrue(videoSection.isVisible());
        Assert.assertTrue(eventsSection.isVisible());
        Assert.assertTrue(filmsSection.isVisible());
        Assert.assertTrue(tvShowsSection.isVisible());
        Assert.assertTrue(gamesAppsSection.isVisible());
        Assert.assertTrue(communitySection.isVisible());
        Assert.assertTrue(dataBankSection.isVisible());
    }

}

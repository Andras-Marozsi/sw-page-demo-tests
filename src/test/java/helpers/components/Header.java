package helpers.components;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Helper for the Header, including search/navigation/etc.
 */
public class Header extends BaseElement {
    private BaseElement navSearch = new BaseElement(By.cssSelector("input#nav-search-input"));
    private BaseElement logo = new BaseElement(By.cssSelector("a#nav-sw-logo"));

    private BaseElement logIn = new BaseElement(By.cssSelector("div.nav-login div.disid-login"));
    private BaseElement signUp = new BaseElement(By.cssSelector("div.nav-login div.disid-signup"));

    // Social Links
    private String socialLinksSelector = "span#navbar ul#social-links";
    private BaseElement socialLinks = new BaseElement(By.cssSelector(socialLinksSelector));
    private BaseElement facebookLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='facebook']"));
    private BaseElement tumblrLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='tumblr']"));
    private BaseElement twitterLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='twitter']"));
    private BaseElement instagramLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='instagram']"));
    private BaseElement googlePlusLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='google plus']"));
    private BaseElement youtubeLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='youtube']"));

    // Sections
    private String sectionsSelector = "ul#section-links";
    private BaseElement sections = new BaseElement(By.cssSelector(sectionsSelector));
    private BaseElement newsSection = new BaseElement(By.cssSelector(sectionsSelector + " a[data-section='news']"));
    private BaseElement videoSection = new BaseElement(By.cssSelector(sectionsSelector + " a[data-section='video']"));
    private BaseElement eventsSection = new BaseElement(By.cssSelector(sectionsSelector + " a[data-section='events']"));
    private BaseElement filmsSection = new BaseElement(By.cssSelector(sectionsSelector + " a[data-section='films']"));
    private BaseElement tvShowsSection = new BaseElement(By.cssSelector(sectionsSelector + " a[data-section='tvshows']"));
    private BaseElement gamesAppsSection = new BaseElement(By.cssSelector(sectionsSelector + " a[data-section='gamesapps']"));
    private BaseElement communitySection = new BaseElement(By.cssSelector(sectionsSelector + " a[data-section='community']"));
    private BaseElement dataBankSection = new BaseElement(By.cssSelector(sectionsSelector + " a[data-section='databank']"));

    public BaseElement getNavSearch() {
        return navSearch;
    }

    /**
     * Constructor with the default base selector
     */
    public Header() {
        super(By.cssSelector("div#nav-inner-container"));
    }

    /**
     * Constructor with a custom base selector
     *
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

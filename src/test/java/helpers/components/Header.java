package helpers.components;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper for the Header, including search/navigation/etc.
 */
public class Header extends BaseElement {
    private BaseElement navSearch = new BaseElement(By.cssSelector("input#nav-search-input"));
    private BaseElement logo = new BaseElement(By.cssSelector("a#nav-sw-logo"));

    private BaseElement logIn = new BaseElement(By.cssSelector("div.nav-login div.disid-login"));
    private BaseElement signUp = new BaseElement(By.cssSelector("div.nav-login div.disid-signup"));

    // Social Links
    private static final String SOCIAL_LINKS_SELECTOR = "span#navbar ul#social-links";
    private BaseElement socialLinks = new BaseElement(By.cssSelector(SOCIAL_LINKS_SELECTOR));
    private BaseElement facebookLink = new BaseElement(By.cssSelector(SOCIAL_LINKS_SELECTOR + " a[title='facebook']"));
    private BaseElement tumblrLink = new BaseElement(By.cssSelector(SOCIAL_LINKS_SELECTOR + " a[title='tumblr']"));
    private BaseElement twitterLink = new BaseElement(By.cssSelector(SOCIAL_LINKS_SELECTOR + " a[title='twitter']"));
    private BaseElement instagramLink = new BaseElement(By.cssSelector(SOCIAL_LINKS_SELECTOR + " a[title='instagram']"));
    private BaseElement googlePlusLink = new BaseElement(By.cssSelector(SOCIAL_LINKS_SELECTOR + " a[title='google plus']"));
    private BaseElement youtubeLink = new BaseElement(By.cssSelector(SOCIAL_LINKS_SELECTOR + " a[title='youtube']"));

    // Sections
    private static final String SECTION_SELECTOR = "ul#section-links";
    private BaseElement sections = new BaseElement(By.cssSelector(SECTION_SELECTOR));
    private BaseElement newsSection = new BaseElement(By.cssSelector(SECTION_SELECTOR + " a[data-section='news']"));
    private BaseElement videoSection = new BaseElement(By.cssSelector(SECTION_SELECTOR + " a[data-section='video']"));
    private BaseElement eventsSection = new BaseElement(By.cssSelector(SECTION_SELECTOR + " a[data-section='events']"));
    private BaseElement filmsSection = new BaseElement(By.cssSelector(SECTION_SELECTOR + " a[data-section='films']"));
    private BaseElement tvShowsSection = new BaseElement(By.cssSelector(SECTION_SELECTOR + " a[data-section='tvshows']"));
    private BaseElement gamesAppsSection = new BaseElement(By.cssSelector(SECTION_SELECTOR + " a[data-section='gamesapps']"));
    private BaseElement communitySection = new BaseElement(By.cssSelector(SECTION_SELECTOR + " a[data-section='community']"));
    private BaseElement dataBankSection = new BaseElement(By.cssSelector(SECTION_SELECTOR + " a[data-section='databank']"));

    public BaseElement getNavSearch() {
        return navSearch;
    }

    public BaseElement getSections() {
        return sections;
    }

    public BaseElement getNewsSection() {
        return newsSection;
    }

    public BaseElement getVideoSection() {
        return videoSection;
    }

    public BaseElement getEventsSection() {
        return eventsSection;
    }

    public BaseElement getFilmsSection() {
        return filmsSection;
    }

    public BaseElement getLogo() {
        return logo;
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
     * Returns the expected elements for desktop layout
     *
     * @return listOfElements
     */
    public List<BaseElement> getExpectedDesktopLayout() {
        List<BaseElement> listOfElements = new ArrayList<BaseElement>();
        listOfElements.add(navSearch);
        listOfElements.add(logo);
        listOfElements.add(logIn);
        listOfElements.add(signUp);
        listOfElements.add(socialLinks);
        listOfElements.add(facebookLink);
        listOfElements.add(tumblrLink);
        listOfElements.add(twitterLink);
        listOfElements.add(instagramLink);
        listOfElements.add(googlePlusLink);
        listOfElements.add(youtubeLink);
        listOfElements.add(sections);
        listOfElements.add(newsSection);
        listOfElements.add(videoSection);
        listOfElements.add(eventsSection);
        listOfElements.add(filmsSection);
        listOfElements.add(tvShowsSection);
        listOfElements.add(gamesAppsSection);
        listOfElements.add(communitySection);
        listOfElements.add(dataBankSection);
        return listOfElements;
    }

}

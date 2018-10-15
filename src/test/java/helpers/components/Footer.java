package helpers.components;

import org.openqa.selenium.By;

/**
 * Helper for the Footer, including links/legal/etc.
 */
public class Footer extends BaseElement {

    // Social Links
    private String socialLinksSelector = "footer ul#social-links";
    private BaseElement socialLinks = new BaseElement(By.cssSelector(socialLinksSelector));
    private BaseElement facebookLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='facebook']"));
    private BaseElement tumblrLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='tumblr']"));
    private BaseElement twitterLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='twitter']"));
    private BaseElement instagramLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='instagram']"));
    private BaseElement googlePlusLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='google plus']"));
    private BaseElement youtubeLink = new BaseElement(By.cssSelector(socialLinksSelector + " a[title='youtube']"));

    // Legal
    private BaseElement legalLinks = new BaseElement(By.cssSelector("ul#legal"));

    /**
     * Constructor with the default base selector
     */
    public Footer() {
        super(By.cssSelector("footer"));
    }

}

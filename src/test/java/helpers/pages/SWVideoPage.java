package helpers.pages;

import helpers.components.BaseElement;
import helpers.components.Footer;
import helpers.components.Header;
import org.openqa.selenium.By;

/**
 * Page helper for Star Wars Video page
 */
public class SWVideoPage extends BaseSWPage {

    private Header header = new Header();
    private Footer footer = new Footer();

    // Sections
    private BaseElement videosSearchBar = new BaseElement(By.cssSelector("section.search input[name='q']"));
    private BaseElement topShowSection = new BaseElement(By.cssSelector("section#ref-1-1"));
    private BaseElement featuredVideosSection = new BaseElement(By.cssSelector("section#ref-1-2"));
    private BaseElement browseVideosSection = new BaseElement(By.cssSelector("section#ref-1-4"));

    /**
     * @return header
     */
    public Header getHeader() {
        return header;
    }

    /**
     * @return footer
     */
    public Footer getFooter() {
        return footer;
    }

    public SWVideoPage() {
        super();
        this.url += "/video";
        this.dataSection = "video";
        listOfDesktopViewElements.add(header);
        listOfDesktopViewElements.add(topShowSection);
        listOfDesktopViewElements.add(featuredVideosSection);
        listOfDesktopViewElements.add(browseVideosSection);
        listOfDesktopViewElements.add(footer);
    }

    /**
     * Types in the provided search phrase and sends the ENTER key to the search bar in the nav
     *
     * @param string to search for
     */
    public void searchVideos(String string) {
        videosSearchBar.sendKeys(string);
        videosSearchBar.submit();
    }

}

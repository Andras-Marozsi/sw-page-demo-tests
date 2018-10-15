package helpers.pages;

import helpers.components.BaseElement;
import helpers.components.Footer;
import helpers.components.Header;
import org.openqa.selenium.By;

/**
 * Page helper for Star Wars Main page
 */
public class SWMainPage extends BaseSWPage {

    private Header header = new Header();
    private Footer footer = new Footer();
    // Sections
    private BaseElement newsSection = new BaseElement(By.cssSelector("section#ref-1-7"));
    private BaseElement videoSection = new BaseElement(By.cssSelector("section#ref-1-9"));
    private BaseElement searchResultsBox = new BaseElement(By.cssSelector("div.search-bound"));

    /**
     * @return newsSection
     */
    public BaseElement getNewsSection() {
        return newsSection;
    }

    /**
     * @return videoSection
     */
    public BaseElement getVideoSection() {
        return videoSection;
    }

    /**
     * @return searchResultsBox
     */
    public BaseElement getSearchResultsBox() {
        return searchResultsBox;
    }

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

    public SWMainPage() {
        super();
        this.url += "/";
        this.dataSection = "";
        listOfDesktopViewElements.add(header);
        listOfDesktopViewElements.add(newsSection);
        listOfDesktopViewElements.add(videoSection);
        listOfDesktopViewElements.add(footer);
    }

}

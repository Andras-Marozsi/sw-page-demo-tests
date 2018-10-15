package helpers.pages;

import helpers.components.BaseElement;
import helpers.components.Footer;
import helpers.components.Header;
import org.openqa.selenium.By;

/**
 * Page helper for Star Wars Video page
 */
public class SWFilmsPage extends BaseSWPage {

    private Header header = new Header();
    private Footer footer = new Footer();

    // Sections
    private BaseElement filmSelector = new BaseElement(By.cssSelector("section[data-module='links_list'] div#film-selector"));
    private BaseElement filmSections = new BaseElement(By.cssSelector("section[data-module='display']"));

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

    public SWFilmsPage() {
        super();
        this.url += "/video";
        this.dataSection = "film";
        listOfDesktopViewElements.add(header);
        listOfDesktopViewElements.add(filmSelector);
        listOfDesktopViewElements.add(filmSections);
        listOfDesktopViewElements.add(footer);
    }

}

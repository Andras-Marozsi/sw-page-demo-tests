package helpers.pages;

import helpers.components.BaseElement;
import helpers.components.Footer;
import helpers.components.Header;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Page helper for Star Wars Video page
 */
public class SWVideoPage extends BasePage {

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
        this.url = "https://www.starwars.com/video";
        this.dataSection = "video";
    }

    /**
     * Types in the provided search phrase and sends the ENTER key to the search bar in the nav
     *
     * @param string to search for
     */
    public void navSearch(String string) {
        videosSearchBar.sendKeys(string);
        videosSearchBar.submit();
    }

    /**
     * Types in the provided search phrase and sends the ENTER key to the search bar on the page
     *
     * @param string to search for
     */
    public void searchVideos(String string) {
        header.getNavSearch().sendKeys(string);
        header.getNavSearch().submit();
    }

    /**
     * Returns the expected elements for desktop layout
     *
     * @return listOfElements
     */
    public List<BaseElement> getExpectedDesktopLayout() {
        List<BaseElement> listOfElements = new ArrayList<BaseElement>();
        listOfElements.add(header);
        listOfElements.add(videosSearchBar);
        listOfElements.add(topShowSection);
        listOfElements.add(featuredVideosSection);
        listOfElements.add(browseVideosSection);
        listOfElements.add(footer);

        List<BaseElement> listOfHeaderElements = header.getExpectedDesktopLayout();
        listOfElements.addAll(listOfHeaderElements);

        return listOfElements;
    }

}

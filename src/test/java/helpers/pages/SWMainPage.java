package helpers.pages;

import helpers.components.BaseElement;
import helpers.components.Footer;
import helpers.components.Header;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Page helper for Star Wars Main page
 */
public class SWMainPage extends BasePage {

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
        this.url = "https://www.starwars.com/";
        this.dataSection = "";
    }

    /**
     * Types in the provided search phrase and sends the ENTER key to the search bar in the nav
     *
     * @param string to search for
     */
    public void search(String string) {
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
        listOfElements.add(newsSection);
        listOfElements.add(videoSection);
        listOfElements.add(footer);

        List<BaseElement> listOfHeaderElements = header.getExpectedDesktopLayout();
        listOfElements.addAll(listOfHeaderElements);

        return listOfElements;
    }

}

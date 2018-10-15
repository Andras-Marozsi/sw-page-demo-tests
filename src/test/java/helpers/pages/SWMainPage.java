package helpers.pages;

import helpers.components.BaseElement;
import helpers.components.Header;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Page helper for Star Wars Main page
 */
public class SWMainPage extends BasePage {

    private Header header = new Header();
    // Sections
    private BaseElement newsSection = new BaseElement(By.cssSelector("section#ref-1-7"));
    private BaseElement videoSection = new BaseElement(By.cssSelector("section#ref-1-9"));
    private BaseElement searchResultsBox = new BaseElement(By.cssSelector("div.search-bound"));

    /**
     * @return searchResultsBox
     */
    public BaseElement getSearchResultsBox() {
        return searchResultsBox;
    }

    /**
     * @return header
     */
    public Header searchResultsBox() {
        return header;
    }

    public SWMainPage() {
        super();
        this.url = "https://www.starwars.com/";
        this.moduleTitle = "THE LATEST //";
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
     * Checks that the elements that need to be displayed on desktop breakpoint are visible
     */
    public void checkDesktopLayout() {
        Assert.assertTrue(newsSection.isVisible());
        header.checkDesktopLayout();
        Assert.assertTrue(videoSection.isVisible());
    }

}

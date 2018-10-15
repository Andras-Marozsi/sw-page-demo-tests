package helpers.pages;

import helpers.components.BaseElement;
import helpers.components.Footer;
import helpers.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Page helper to perform basic page actions like loading page, refresh, etc.
 */
public class BaseSWPage {

    protected static WebDriver driver;
    protected String url = "https://www.starwars.com";
    protected String dataSection;
    protected List<BaseElement> listOfDesktopViewElements = new ArrayList<BaseElement>();
    protected Header header = new Header();
    protected Footer footer = new Footer();
    private BaseElement searchResultsBox = new BaseElement(By.cssSelector("div.search-bound"));

    /**
     * @return searchResultsBox
     */
    public BaseElement getSearchResultsBox() {
        return searchResultsBox;
    }

    /**
     * Sets the driver that will be shared among page objects
     *
     * @param d driver
     */
    public static void setDriver(WebDriver d) {
        driver = d;
    }

    /**
     * Loads the page
     */
    public void visit() {
        System.out.printf("Loading url: %s\n", this.url);
        driver.get(this.url);
    }

    /**
     * Defines if the currently loaded page is this page. The validation is based on the module title, might need to be
     * overridden in derived classes
     *
     * @return boolean value
     */
    public boolean isCurrentPage() {
        boolean current;
        BaseElement module = new BaseElement(By.cssSelector("div#body-wrapper"));
        if (module.isPresent()) {
            current = module.getAttribute("data-section").equals(this.dataSection);
        } else {
            current = false;
        }
        return current;
    }

    /**
     * Returns the expected elements for desktop layout
     *
     * @return listOfElements
     */
    public List<BaseElement> getExpectedDesktopLayout() {
        List<BaseElement> listOfHeaderElements = this.header.getExpectedDesktopLayout();
        this.listOfDesktopViewElements.addAll(listOfHeaderElements);

        return this.listOfDesktopViewElements;
    }

    /**
     * Types in the provided search phrase and sends the ENTER key to the search bar on the page
     *
     * @param string to search for
     */
    public void search(String string) {
        this.header.getNavSearch().sendKeys(string);
        this.header.getNavSearch().submit();
    }
}

package helpers.components;

import org.openqa.selenium.By;

/**
 * Helper for the Footer, including links/legal/etc.
 */
public class Section extends BaseElement {

    private static final By ARTICLE_SELECTOR = By.cssSelector("div.building-block");
    private static final By SHOW_MORE_SELECTOR = By.cssSelector("div.show_more_container a");

    /**
     * Constructor with the default base selector
     */
    public Section(By selector) {
        super(selector);
    }

    /**
     * Returns the number of articles inside the section
     * @return number of articles in the section
     */
    public int getNumberOfArticles() {
        return this.getElement().findElements(ARTICLE_SELECTOR).size();
    }

    /**
     * Clicks on the show more button inside the section
     */
    public void clickShowMore() {
        this.getElement().findElement(SHOW_MORE_SELECTOR).click();
    }

}

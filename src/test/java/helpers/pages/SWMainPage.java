package helpers.pages;

import helpers.components.BaseElement;
import org.openqa.selenium.By;

/**
 * Page helper for Star Wars Main page
 */
public class SWMainPage extends BaseSWPage {
    // Sections
    private BaseElement newsSection = new BaseElement(By.cssSelector("section#ref-1-7"));
    private BaseElement videoSection = new BaseElement(By.cssSelector("section#ref-1-9"));

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

    public SWMainPage() {
        super();
        this.url += "/";
        this.dataSection = "";
        listOfDesktopViewElements.add(this.header);
        listOfDesktopViewElements.add(newsSection);
        listOfDesktopViewElements.add(videoSection);
        listOfDesktopViewElements.add(this.footer);
    }

}

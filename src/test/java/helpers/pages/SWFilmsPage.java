package helpers.pages;

import helpers.components.BaseElement;
import org.openqa.selenium.By;

/**
 * Page helper for Star Wars Video page
 */
public class SWFilmsPage extends BaseSWPage {

    // Sections
    private BaseElement filmSelector = new BaseElement(By.cssSelector("section[data-module='links_list'] div#film-selector"));
    private BaseElement filmSections = new BaseElement(By.cssSelector("section[data-module='display']"));

    public SWFilmsPage() {
        super();
        this.url += "/films";
        this.dataSection = "films";
        listOfDesktopViewElements.add(this.header);
        listOfDesktopViewElements.add(filmSelector);
        listOfDesktopViewElements.add(filmSections);
        listOfDesktopViewElements.add(this.footer);
    }

}

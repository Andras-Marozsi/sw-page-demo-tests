package helpers.pages;

import helpers.components.Section;
import org.openqa.selenium.By;

/**
 * Page helper for Star Wars Main page
 */
public class SWMainPage extends BaseSWPage {
    // Sections
    private Section newsSection = new Section(By.cssSelector("section#ref-1-7"));
    private Section videoSection = new Section(By.cssSelector("section#ref-1-9"));
    private Section dataBankSection = new Section(By.cssSelector("section#ref-1-16"));

    /**
     * @return newsSection
     */
    public Section getNewsSection() {
        return newsSection;
    }

    /**
     * @return videoSection
     */
    public Section getVideoSection() {
        return videoSection;
    }

    /**
     * @return dataBankSection
     */
    public Section getDataBankSection() {
        return dataBankSection;
    }

    public SWMainPage() {
        super();
        this.url += "/";
        this.dataSection = "";
        listOfDesktopViewElements.add(this.header);
        listOfDesktopViewElements.add(newsSection);
        listOfDesktopViewElements.add(videoSection);
        listOfDesktopViewElements.add(dataBankSection);
        listOfDesktopViewElements.add(this.footer);
    }

}

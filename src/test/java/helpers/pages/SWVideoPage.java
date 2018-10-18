package helpers.pages;

import helpers.components.BaseElement;
import helpers.components.CustomPlayer;
import org.openqa.selenium.By;

/**
 * Page helper for Star Wars Video page
 */
public class SWVideoPage extends BaseSWPage {

    // Sections
    private BaseElement videosSearchBar = new BaseElement(By.cssSelector("section.search input[name='q']"));
    private BaseElement topShowSection = new BaseElement(By.cssSelector("section#ref-1-1"));
    private BaseElement featuredVideosSection = new BaseElement(By.cssSelector("section#ref-1-2"));
    private BaseElement browseVideosSection = new BaseElement(By.cssSelector("section#ref-1-4"));

    private BaseElement articleWithCustomPlayer = new BaseElement(By.cssSelector("article#burger div.building-block .title a[data-slug^='video/']"));
    private CustomPlayer customPlayer = new CustomPlayer();

    public CustomPlayer getCustomPlayer() {
        return customPlayer;
    }

    public SWVideoPage() {
        super();
        this.url += "/video";
        this.dataSection = "video";
        listOfDesktopViewElements.add(this.header);
        listOfDesktopViewElements.add(topShowSection);
        listOfDesktopViewElements.add(featuredVideosSection);
        listOfDesktopViewElements.add(browseVideosSection);
        listOfDesktopViewElements.add(this.footer);
    }

    /**
     * Types in the provided search phrase and sends the ENTER key to the search bar in the nav
     *
     * @param string to search for
     */
    public void searchVideos(String string) {
        videosSearchBar.sendKeys(string);
        videosSearchBar.submit();
    }

    /**
     * Checks if there are articles with custom player on the page
     * @return boolean if there are articles with custom player
     */
    public boolean hasArticleWithCustomPlayer() {
        return articleWithCustomPlayer.isVisible();
    }

    /**
     * Clicks on the nth article on the page with custom player
     * @param index of element to click
     */
    public void clickNthArticleWithCustomPlayer(int index) {
        driver.findElements(articleWithCustomPlayer.getSelector()).get(index).click();
    }

}

package helpers.pages;

import helpers.components.BaseElement;
import helpers.components.Header;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SWMainPage extends BasePage {

    public Header header = new Header();
    // Sections
    private BaseElement newsSection = new BaseElement(By.cssSelector("section#ref-1-7"));
    private BaseElement videoSection = new BaseElement(By.cssSelector("section#ref-1-9"));
    public BaseElement searchResultsBox = new BaseElement(By.cssSelector("div.search-bound"));

    public SWMainPage() {
        super();
        this.url = "https://www.starwars.com/";
        this.moduleTitle = "THE LATEST //";
    }

    public void search(String string) {
        header.navSearch.sendKeys(string);
        header.navSearch.submit();
    }

    public void checkDesktopLayout() {
        Assert.assertTrue(newsSection.isVisible());
        header.checkDesktopLayout();
        Assert.assertTrue(videoSection.isVisible());
    }

}

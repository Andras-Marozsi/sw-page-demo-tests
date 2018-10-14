package helpers.pages;

import helpers.components.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page helper to perform basic page actions like loading page, refresh, etc.
 */
public class BasePage {

    protected static WebDriver driver;
    protected String url;
    protected String moduleTitle;

    /**
     * Sets the driver that will be shared among page objects
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
     * @return boolean value
     */
    public boolean isCurrentPage() {
        boolean current;
        BaseElement module = new BaseElement(By.cssSelector("h2.module_title"));
        if (module.isPresent()) {
            current = module.getText().equals(this.moduleTitle);
        } else {
            current = false;
        }
        return current;
    }
}

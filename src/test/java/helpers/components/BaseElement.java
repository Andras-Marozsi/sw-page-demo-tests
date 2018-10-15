package helpers.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Helper for basic element interactions
 */
public class BaseElement {

    protected static WebDriver driver;
    protected By selector;

    /**
     * Constructor for the helper, will use the selector provided here for later interactions
     *
     * @param selector Selector of the element
     */
    public BaseElement(By selector) {
        this.selector = selector;
    }

    /**
     * Sets the driver to use, this will ba shared between all elements
     *
     * @param d Driver to use
     */
    public static void setDriver(WebDriver d) {
        driver = d;
    }

    /**
     * Checks if the element is present and visible on the page.
     * Handles the case when the element is missing from the page
     *
     * @return visibility of the element
     */
    public boolean isVisible() {
        System.out.printf("Checking visibility of element %s\n", this.selector);
        boolean visibility;
        if (this.isPresent()) {
            visibility = driver.findElement(this.selector).isDisplayed();
        } else {
            visibility = false;
        }
        return visibility;
    }

    /**
     * Checks if the element is present on the page
     *
     * @return presence of the element
     */
    public boolean isPresent() {
        System.out.printf("Checking presence of element %s\n", this.selector);
        return driver.findElements(this.selector).size() != 0;
    }

    /**
     * Scrolls to the element
     */
    public void scrollTo() {
        System.out.printf("Scrolling to element %s\n", this.selector);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(this.selector));
    }

    /**
     * Clicks on the element
     */
    public void click() {
        scrollTo();
        System.out.printf("Clicking on element %s\n", this.selector);
        driver.findElement(this.selector).click();
    }

    /**
     * Sends a string to the element
     *
     * @param string String to send
     */
    public void sendKeys(String string) {
        System.out.printf("Entering '%s' to element %s\n", string, this.selector);
        driver.findElement(this.selector).sendKeys(string);
    }

    /**
     * Sends the ENTER key to the element
     */
    public void submit() {
        System.out.printf("Sending ENTER key to element %s\n", this.selector);
        driver.findElement(this.selector).sendKeys(Keys.ENTER);
    }

    /**
     * Returns the text of the element
     *
     * @return text of element
     */
    public String getText() {
        System.out.printf("Getting text of element %s\n", this.selector);
        return driver.findElement(this.selector).getText();
    }

    /**
     * Getting the specified attribute of element
     * @param attr attribute to get
     * @return attribute of element
     */
    public String getAttribute(String attr) {
        System.out.printf("Getting attribute '"  + attr + "' of element %s\n", this.selector);
        return driver.findElement(this.selector).getAttribute(attr);
    }
}

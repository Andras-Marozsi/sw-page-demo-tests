package helpers.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Helper for the Footer, including links/legal/etc.
 */
public class CustomPlayer extends BaseElement {

    private static final String PAUSED = "playkit-state-paused";
    private BaseElement stateIndicator = new BaseElement(By.cssSelector("div#video_wrapper div.playkit-player"));
    private BaseElement playPauseIcon = new BaseElement(By.cssSelector("div#video_wrapper i.playkit-icon-play"));

    /**
     * Constructor with the default base selector
     */
    public CustomPlayer() {
        super(By.cssSelector("div.playkit-video-player"));
    }

    /**
     * Custom click for the player with inbuilt wait
     */
    public void playPause() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", playPauseIcon.getElement());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if the player is playing
     *
     * @return isPlaying
     */
    public boolean isPlaying() {
        return !this.isPaused();
    }

    /**
     * Checks if the player is paused
     *
     * @return isPaused
     */
    public boolean isPaused() {
        return stateIndicator.getAttribute("class").contains(PAUSED);
    }

}

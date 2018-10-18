package helpers.utils;

public class Helper {

    /**
     * Wait for the provided time
     * @param mSec wait time in milliseconds
     */
    public static void waitInMSec (int mSec) {
        try {
            Thread.sleep(mSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

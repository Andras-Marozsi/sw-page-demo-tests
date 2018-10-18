package helpers.utils;

public class Constants {

    public static final String PAGE_LOAD_FINISHED_SCRIPT = "" +
            "if (document.readyState == 'complete' && jQuery.active == 0) {"
            + "  return true;"
            + "} else {"
            + "  throw new Error('Background calls are not finished')"
            + "}";
    public static final int TIEMOUT_IN_SEC_FAST = 5;
    public static final int TIEMOUT_IN_SEC_MEDIUM = 15;
    public static final int TIEMOUT_IN_SEC_SLOW = 30;
}

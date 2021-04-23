package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ElementHelper {
    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}

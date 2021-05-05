package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementHelper {
    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserHelper.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void selectDropdownByText(WebElement element, String text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public static void selectDropdownByIndex(WebElement element, Integer index) {
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }

    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}

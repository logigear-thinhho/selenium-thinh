package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    public static void untilElementExist(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(BrowserHelper.getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean forTitle(String title, int seconds) {
        WebDriverWait wait = new WebDriverWait(BrowserHelper.getDriver(), seconds);
        return wait.until(ExpectedConditions.titleIs(title));
    }

    public static void untilAvailable(By element, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(BrowserHelper.getDriver(), time);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static void untilAbc(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(BrowserHelper.getDriver(), seconds);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }


}

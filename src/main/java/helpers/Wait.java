package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    public static void untilElementExist(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean forTitle(String title, int seconds) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, seconds);
        return wait.until(ExpectedConditions.titleIs(title));
    }

    public static void forStep(By element, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, time);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }


}

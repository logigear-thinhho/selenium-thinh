package page_objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    private final By tabLogin = By.cssSelector("li a[href='/Account/Login.cshtml']");
    private final By tabLogout = By.cssSelector("a[href='/Account/Logout']");

    public void gotoLoginPage() {
        BrowserHelper.getDriver().findElement(tabLogin).click();
    }

    public void clickLogout() {
        BrowserHelper.getDriver().findElement(tabLogout).click();
    }

}

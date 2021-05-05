package page_objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;

public class ContactPage extends BasePage {
    private final By lnkEmail = By.cssSelector(".contact a");

    public String getEmailHref() {
        return BrowserHelper.getDriver().findElement(lnkEmail).getAttribute("href");
    }
}

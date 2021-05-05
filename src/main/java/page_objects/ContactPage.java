package page_objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;

public class ContactPage extends BasePage {
    private final By lnkEmail = By.linkText("thanh.viet.le@logigear.com");

    public String getEmailHref() {
        return BrowserHelper.getDriver().findElement(lnkEmail).getAttribute("href");
    }

}

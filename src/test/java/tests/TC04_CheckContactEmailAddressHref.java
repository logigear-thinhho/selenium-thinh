package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ContactPage;

public class TC04_CheckContactEmailAddressHref extends BaseTest {
    ContactPage contactPage = new ContactPage();

    @Test(description = "Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog")
    public void TC04() {
        contactPage.gotoContactPage();

        String actualEmailHref = contactPage.getEmailHref();
        String expectedEmailHref = "mailto:thanh.viet.le@logigear.com";

        Assert.assertEquals(actualEmailHref, expectedEmailHref, "Email address's href is not match!");
    }

}

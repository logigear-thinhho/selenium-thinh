package page_objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;

public class BasePage {
    private final By tabLogin = By.cssSelector("li a[href='/Account/Login.cshtml']");
    private final By tabLogout = By.cssSelector("a[href='/Account/Logout']");
    private final By tabRegister = By.cssSelector("a[href='/Account/Register.cshtml'");
    private final By tabBookTicket = By.cssSelector("a[href='/Page/BookTicketPage.cshtml'");
    private final By tabContact = By.cssSelector("a[href='/Page/Contact.cshtml'");

    public void gotoLoginPage() {
        BrowserHelper.getDriver().findElement(tabLogin).click();
    }

    public void clickLogout() {
        BrowserHelper.getDriver().findElement(tabLogout).click();
    }

    public void gotoRegisterPage() {
        BrowserHelper.getDriver().findElement(tabRegister).click();
    }

    public void gotoBookTicketPage() {
        BrowserHelper.getDriver().findElement(tabBookTicket).click();
    }

    public void gotoContactPage() {
        BrowserHelper.getDriver().findElement(tabContact).click();
    }
}

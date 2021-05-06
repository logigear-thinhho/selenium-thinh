package page_objects;

import helpers.BrowserHelper;
import helpers.Constant;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;

public class BasePage {
    private final By tabLogin = By.cssSelector("li a[href='/Account/Login.cshtml']");
    private final By tabLogout = By.cssSelector("a[href='/Account/Logout']");
    private final By tabRegister = By.cssSelector("a[href='/Account/Register.cshtml'");
    private final By tabBookTicket = By.cssSelector("a[href='/Page/BookTicketPage.cshtml'");
    private final By tabContact = By.cssSelector("a[href='/Page/Contact.cshtml'");
    private final By tabMyTicket = By.cssSelector("a[href='/Page/ManageTicket.cshtml'");
    private final By tabChangePassword = By.cssSelector("a[href='/Account/ChangePassword.cshtml'");
    private final By pageHeader = By.cssSelector("#content h1");

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

    public void gotoChangePasswordPage() {
        BrowserHelper.getDriver().findElement(tabChangePassword).click();
    }

    public void gotoMyTicketPage() {
        BrowserHelper.getDriver().findElement(tabMyTicket).click();
    }

    public boolean doesMyTicketTabExist() {
        return ElementHelper.doesElementExist(BrowserHelper.getDriver().findElement(tabMyTicket));
    }

    public boolean doesChangePasswordTabExist() {
        return ElementHelper.doesElementExist(BrowserHelper.getDriver().findElement(tabChangePassword));
    }

    public boolean doesLogoutTabExist() {
        return ElementHelper.doesElementExist(BrowserHelper.getDriver().findElement(tabLogout));
    }

    public String getPageHeader() {
        Wait.untilElementExist(pageHeader, Constant.SHORT_TIME);
        return BrowserHelper.getDriver().findElement(pageHeader).getText();
    }
}

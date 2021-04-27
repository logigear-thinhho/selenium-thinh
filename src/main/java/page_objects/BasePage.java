package page_objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    private final By tabLogin = By.cssSelector("a[href*='Login']");
    private final By tabLogout = By.cssSelector("a[href$='Logout']");
    private final By tabRegister = By.cssSelector("a[href*='/Register']");
    private final By tabBookTicket = By.cssSelector("a[href*='BookTicket']");

    protected WebElement getTabLogin() {
        return BrowserHelper.getDriver().findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return BrowserHelper.getDriver().findElement(tabLogout);
    }

    protected WebElement getTabRegister() {
        return BrowserHelper.getDriver().findElement(tabRegister);
    }

    protected WebElement getTabBookTicket() {
        return BrowserHelper.getDriver().findElement(tabBookTicket);
    }


    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoLogout() {
        this.getTabLogout().click();
    }
}


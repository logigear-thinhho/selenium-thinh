package page_objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    private final By tabLogin = By.cssSelector("a[href*='Login']");
    private final By tabLogout = By.cssSelector("a[href$='Logout']");
    private final By tabRegister = By.cssSelector("a[href*='/Register']");
    private final By tabBookTicket = By.cssSelector("a[href*='BookTicket']");

    private WebElement getTabLogin() {
        return BrowserHelper.getDriver().findElement(tabLogin);
    }

    private WebElement getTabLogout() {
        return BrowserHelper.getDriver().findElement(tabLogout);
    }

    private WebElement getTabRegister() {
        return BrowserHelper.getDriver().findElement(tabRegister);
    }

    private WebElement getTabBookTicket() {
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

    public void clickLogout() {
        this.getTabLogout().click();
    }
}


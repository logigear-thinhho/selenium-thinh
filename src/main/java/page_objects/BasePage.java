package page_objects;

import helpers.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    private final By tabLogin = By.cssSelector("a[href*='Login']");
    private final By tabLogout = By.cssSelector("a[href$='Logout']");
    private final By tabRegister = By.cssSelector("a[href*='/Register']");
    private final By tabBookTicket = By.cssSelector("a[href*='BookTicket']");

    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
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


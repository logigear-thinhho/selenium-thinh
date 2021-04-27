package page_objects;

import helpers.BrowserHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.cssSelector("input[type='submit']");
    private final By lblLoginErrorMsg = By.cssSelector(".message.error.LoginForm");
    private final By lblWelcomeMessage = By.cssSelector(".account strong");

    public WebElement getTxtUsername() {
        return BrowserHelper.getDriver().findElement(txtUsername);
    }

    public WebElement getTxtPassword() {
        return BrowserHelper.getDriver().findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return BrowserHelper.getDriver().findElement(btnLogin);
    }

    public WebElement getLblErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblLoginErrorMsg);
    }

    public WebElement getLblWelcomeMessage() {
        return BrowserHelper.getDriver().findElement(lblWelcomeMessage);
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public String getErrorMessage() {
        return this.getLblErrorMsg().getText();
    }

    //Methods
    public void login(String username, String password) {
        getTxtUsername().clear();
        this.getTxtUsername().sendKeys(username);
        getTxtPassword().clear();
        this.getTxtPassword().sendKeys(password);
        ElementHelper.scrollToView(getBtnLogin());
        this.getBtnLogin().click();
    }

    public void logout() {
        BasePage basePage = new BasePage();
        basePage.getTabLogout().click();
    }

}

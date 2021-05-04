package page_objects;

import helpers.BrowserHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.cssSelector("input[type='submit']");
    private final By lblLoginErrorMsg = By.cssSelector(".message.error.LoginForm");
    private final By lblWelcomeMessage = By.cssSelector(".account strong");

    private WebElement getTxtEmail() {
        return BrowserHelper.getDriver().findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return BrowserHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return BrowserHelper.getDriver().findElement(btnLogin);
    }

    private WebElement getLblErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblLoginErrorMsg);
    }

    private WebElement getLblWelcomeMessage() {
        return BrowserHelper.getDriver().findElement(lblWelcomeMessage);
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public String getErrorMessage() {
        return this.getLblErrorMsg().getText();
    }

    public void login(String email, String password) {
        getTxtEmail().clear();
        this.getTxtEmail().sendKeys(email);
        getTxtPassword().clear();
        this.getTxtPassword().sendKeys(password);
        ElementHelper.scrollToView(getBtnLogin());
        this.getBtnLogin().click();
    }

    public void logout() {
        clickLogout();
    }

}

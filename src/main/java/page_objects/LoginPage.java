package page_objects;

import helpers.BrowserHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.cssSelector("input[value='Login']");
    private final By lblLoginErrorMsg = By.cssSelector(".message.error.LoginForm");
    private final By lblWelcomeMessage = By.className("account");
    //Reset Password Page
    private final By lnkForgotPassword = By.cssSelector("a[href='/Account/ForgotPassword.cshtml']");
    private final By txtForgotEmail = By.id("email");
    private final By lblForgotPasswordErrorMsg = By.cssSelector(".message.error");
    private final By btnSendInstructions = By.cssSelector("input[value='Send Instructions']");

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

    private WebElement getLblForgotPasswordErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblForgotPasswordErrorMsg);
    }

    private WebElement getTxtForgotEmail() {
        return BrowserHelper.getDriver().findElement(txtForgotEmail);
    }

    private WebElement getBtnSendInstructions() {
        return BrowserHelper.getDriver().findElement(btnSendInstructions);
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public String getErrorMessage() {
        return this.getLblErrorMsg().getText();
    }

    public String getForgotPasswordErrorMsg() {
        return this.getLblForgotPasswordErrorMsg().getText();
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

    public void gotoForgotPasswordPage() {
        BrowserHelper.getDriver().findElement(lnkForgotPassword).click();
    }

    public void resetPassword(String email) {
        getTxtForgotEmail().clear();
        this.getTxtForgotEmail().sendKeys(email);
        this.getBtnSendInstructions().click();
    }
}

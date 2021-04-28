package page_objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.cssSelector("input[type='submit']");
    private final By lblSuccessMsg = By.cssSelector(".message.success");

    private WebElement getTxtCurrentPassword() {
        return BrowserHelper.getDriver().findElement(txtCurrentPassword);
    }

    private WebElement getTxtNewPassword() {
        return BrowserHelper.getDriver().findElement(txtNewPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return BrowserHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword() {
        return BrowserHelper.getDriver().findElement(btnChangePassword);
    }

    private WebElement getLblSuccessMsg() {
        return BrowserHelper.getDriver().findElement(lblSuccessMsg);
    }

    public String getSuccessMsg() {
        return this.getLblSuccessMsg().getText();
    }
}

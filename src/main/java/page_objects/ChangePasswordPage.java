package page_objects;

import helpers.BrowserHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.cssSelector("input[type='submit']");
    private final By lblSuccessMsg = By.cssSelector(".message.success");
    private final By lblErrorMsg = By.cssSelector(".message.error");

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

    private WebElement getLblErrorMsg(){
        return BrowserHelper.getDriver().findElement(lblErrorMsg);
    }

    public String getSuccessMsg() {
        return this.getLblSuccessMsg().getText();
    }

    public  String getErrorMsg(){
        return this.getLblErrorMsg().getText();
    }

    public void changePassword(String username, String password, String confirmPassword) {
        getTxtCurrentPassword().clear();
        this.getTxtCurrentPassword().sendKeys(username);

        getTxtNewPassword().clear();
        this.getTxtNewPassword().sendKeys(password);

        getTxtConfirmPassword().clear();
        this.getTxtConfirmPassword().sendKeys(confirmPassword);

        ElementHelper.scrollToView(getBtnChangePassword());
        this.getBtnChangePassword().click();
    }
}

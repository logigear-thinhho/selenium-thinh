package page_objects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.cssSelector("input[value='Register']");

    public WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getTxtPid() {
        return Constant.WEBDRIVER.findElement(txtPid);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    //Methods
    public void register(String email, String password, String confirmPassword, String pid) {
        getTxtEmail().clear();
        this.getTxtEmail().sendKeys(email);

        getTxtPassword().clear();
        this.getTxtPassword().sendKeys(password);

        getTxtConfirmPassword().clear();
        this.getTxtConfirmPassword().sendKeys(confirmPassword);

        getTxtPid().clear();
        this.getTxtPid().sendKeys(pid);

        this.getBtnRegister().click();
    }
}

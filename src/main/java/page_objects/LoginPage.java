package page_objects;

import common.constants.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.cssSelector("input[value='Login']");
    private final By lblLoginErrorMsg = By.cssSelector(".message.error.LoginForm");
    private final By lblWelcomeMessage = By.cssSelector(".account strong");

    public WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin(){
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLblErrorMsg(){
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    public WebElement getLblWelcomeMessage(){ return Constant.WEBDRIVER.findElement(lblWelcomeMessage); }

    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }

    public String getErrorMessage(){
        return this.getLblErrorMsg().getText();
    }

    //Methods
    public void login(String username, String password){
        getTxtUsername().clear();
        this.getTxtUsername().sendKeys(username);
        getTxtPassword().clear();
        this.getTxtPassword().sendKeys(password);

        JavascriptExecutor jse = (JavascriptExecutor)Constant.WEBDRIVER;
        jse.executeScript("window.scrollBy(0,300)");

        this.getBtnLogin().click();
    }

    public void logout(){
        BasePage basePage = new BasePage();
        basePage.getTabLogout().click();
    }




}

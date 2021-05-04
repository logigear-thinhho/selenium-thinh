package tests;

import helpers.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class TC01_LoginWithValidAccount extends BaseTest{
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() {
        loginPage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.EMAIL;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

}

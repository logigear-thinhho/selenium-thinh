package tests;

import helpers.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class TC02_LoginWithBlankUsername extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can't login with blank Username textbox")
    public void TC02() {
        loginPage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}

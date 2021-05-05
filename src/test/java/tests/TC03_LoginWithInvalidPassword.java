package tests;

import helpers.Constant;
import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class TC03_LoginWithInvalidPassword extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03() {
        loginPage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, DataHelper.getRandomText());

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}

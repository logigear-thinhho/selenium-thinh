package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TC10_ResetPasswordWithIncorrectEmail extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can't reset password if enter incorrect email address")
    public void TC10() {
        String email = "unregisteremail6969@gmail.com";

        loginPage.gotoLoginPage();
        loginPage.gotoForgotPasswordPage();
        loginPage.resetPassword(email);

        String actualMsg = loginPage.getForgotPasswordErrorMsg();
        String expectedMsg = "This email address doesn't exist.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class TC11_RegisterWithEmptyFields extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11() {
        String email = "newemailfortest69@gmail.com";

        homePage.gotoRegisterPage();
        registerPage.register(email, "", "", "");

        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualPasswordErrorMsg = registerPage.getPasswordErrorMsg();
        String expectedPasswordErrorMsg = "Invalid password length";
        String actualPidErrorMsg = registerPage.getPidErrorMsg();
        String expectedPidErrorMsg = "Invalid ID length";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
        Assert.assertEquals(actualPasswordErrorMsg, expectedPasswordErrorMsg, "Error message is not displayed as expected");
        Assert.assertEquals(actualPidErrorMsg, expectedPidErrorMsg, "Error message is not displayed as expected");
    }
}

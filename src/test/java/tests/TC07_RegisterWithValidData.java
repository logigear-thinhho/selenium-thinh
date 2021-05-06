package tests;

import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class TC07_RegisterWithValidData extends BaseTest {
    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();

    @Test(description = "User can create new account")
    public void TC07() {
        homePage.gotoRegisterPage();

        String email = DataHelper.getRandomEmail();
        String password = DataHelper.getRandomText();
        String pid = DataHelper.getRandomNumber();

        registerPage.register(email, password, password, pid);

        String actualMsg = registerPage.getConfirmMessage();
        String expectedMsg = "You're here";

        Assert.assertEquals(actualMsg, expectedMsg, "Registration error!");
    }
}

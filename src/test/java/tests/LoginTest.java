package tests;

import helpers.DataProviderHelper;
import helpers.LogHelper;
import models.Login;
import org.apache.log4j.BasicConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod() {
        loginPage.gotoLoginPage();
        BasicConfigurator.configure();
    }

    @Test(description = "User cannot log in to Railway with blank email and password")
    public void TC01() {
        LogHelper.startTestCase("TC01 - User cannot log in to Railway with blank email and password");

        loginPage.login("", "");

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test(description = "User can log in to Railway with valid account", dataProviderClass = DataProviderHelper.class, dataProvider = "valid-login")
    public void TC02(Login login) {
        System.out.println("TC02 - User can log in to Railway with valid account");

        loginPage.login(login.getUsername(), login.getPassword());

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = login.getMessage();

        loginPage.logout();

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test(description = "User cannot log in to Railway with invalid email and password", dataProviderClass = DataProviderHelper.class, dataProvider = "invalid-login")
    public void TC03(Login login) {
        System.out.println("TC03 - User cannot log in to Railway with invalid email and password");

        loginPage.login(login.getUsername(), login.getPassword());

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = login.getMessage();

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

}

package tests;

import helpers.DataProviderHelper;
import org.apache.log4j.BasicConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.RegisterPage;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeMethod() {
        registerPage.gotoRegisterPage();
        BasicConfigurator.configure();
    }

    @Test(description = "User can create an account", dataProviderClass = DataProviderHelper.class, dataProvider = "valid-create")
    public void TC01() {
        System.out.println("TC01 - User can log in to Railway with valid account");

        loginPage.login(login.getUsername(), login.getPassword());

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = login.getMessage();

        loginPage.logout();

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

}

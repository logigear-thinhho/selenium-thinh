package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.Common;
import helpers.Constant;
import helpers.LogHelper;
import models.Login;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.LoginPage;

import java.io.IOException;
import java.util.List;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test(description = "User cannot log in to Railway with blank email and password")
    public void TC01() {
        LogHelper.startTestCase("TC01 - User cannot log in to Railway with blank email and password");

        loginPage.gotoLoginPage();
        loginPage.login("", "");

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test(description = "User can log in to Railway with valid account")
    public void TC02() {
        LogHelper.startTestCase("TC02 - User can log in to Railway with valid account");

        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test(description = "User cannot log in to Railway with invalid email and password", dataProvider = "invalidLogin")
    public void TC03(Login login) {
        System.out.println("TC03 - User cannot log in to Railway with invalid email and password");

        loginPage.gotoLoginPage();
        loginPage.login(login.getUsername(), login.getPassword());

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = login.getMessage();

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @DataProvider(name = "invalidLogin")
    public static Object[] getInvalidLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Login> logins = objectMapper.readValue(Common.readFile("/src/test/resources/test_data/invalidLogin.json"), new TypeReference<List<Login>>() {
        });
        return logins.toArray();
    }

}

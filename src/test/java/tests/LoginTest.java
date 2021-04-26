package tests;

import helpers.Common;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class LoginTest extends BaseTest {
    Common common = new Common();
    LoginPage loginPage = new LoginPage();


    @Test(description = "User cannot log in to Railway with blank email and password")
    public void TC01() {
        System.out.println("TC01 - User cannot log in to Railway with blank email and password");

        common.openRailway();
        loginPage.gotoLoginPage();
        loginPage.login("", "");

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

}

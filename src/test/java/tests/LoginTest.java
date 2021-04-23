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

public class LoginTest extends BaseTest {
    Common common = new Common();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User cannot log in to Railway with blank email and password")
    public void TC01() {
        common.openRailway();
        loginPage.gotoLoginPage();
        loginPage.login("","");
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test(description = "User cannot log in to Railway with blank email, password and can log into site with valid username,password")
    public void TC02() throws InterruptedException, IOException, ParseException {
        readWriteJSON();
    }

    @SuppressWarnings("unchecked")
    public void readWriteJSON() throws InterruptedException, IOException, ParseException {
        common.openRailway();
        loginPage.gotoLoginPage();
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader(Common.getProjectPath() + "\\src\\test\\resources\\FileInputStream\\data.json");
            Object obj = jsonParser.parse(reader);
            JSONArray usersList = (JSONArray) obj;
            System.out.println("Users List-> " + usersList); //This prints the entire json file
            for (int i = 0; i < usersList.size(); i++) {
                JSONObject users = (JSONObject) usersList.get(i);
                System.out.println("Users -> " + users);//This prints every block - one json object
                JSONObject user = (JSONObject) users.get("users");
                System.out.println("User -> " + user); //This prints each data in the block
                String username = (String) user.get("username");
                String password = (String) user.get("password");
                loginPage.login(username, password);

                if (!loginPage.getWelcomeMessage().equals("Welcome guest!")) {
                    String actualMsg = loginPage.getWelcomeMessage();
                    String expectedMsg = "Welcome " + user.get("username");
                    System.out.println("Actual Message:" + actualMsg);
                    System.out.println("Expected Message:" + expectedMsg);
                    junit.framework.Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
                    loginPage.logout();
                } else {
                    String actualMsg = loginPage.getErrorMessage();
                    String expectedMsg = "Invalid username or password. Please try again.";
                    System.out.println("Actual Message:" + actualMsg);
                    System.out.println("Expected Message:" + expectedMsg);
                    junit.framework.Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


}

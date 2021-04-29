package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.Common;
import models.ChangePassword;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.LoginPage;

import java.io.IOException;
import java.util.List;

public class ChangePasswordTest extends BaseTest {
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    LoginPage loginPage = new LoginPage();
    String username = "testerabc@gmail.com";
    String password = "11111111";

    @Test(description = "Users can change their password")
    public void TC01() {
        String newPassword = "123123123";

        loginPage.gotoLoginPage();
        loginPage.login(username, password);

        changePasswordPage.gotoChangePasswordPage();
        changePasswordPage.changePassword(password, newPassword, newPassword);

        String actualMsg = changePasswordPage.getSuccessMsg();
        String expectedMsg = "Your password has been updated!";

        Assert.assertEquals(actualMsg, expectedMsg, actualMsg + " is not matched with " + expectedMsg);
    }

    @Test(description = "Users can not change their password with invalid data", dataProvider = "invalidChangePassword")
    public void TC02(ChangePassword changePassword) {
        loginPage.gotoLoginPage();
        loginPage.login(username, password);

        changePasswordPage.gotoChangePasswordPage();
        changePasswordPage.changePassword(changePassword.getCurrentPassword(), changePassword.getNewPassword(), changePassword.getConfirmPassword());

        String actualMsg = changePasswordPage.getErrorMsg();
        String expectedMsg = changePassword.getMessage();

        Assert.assertEquals(actualMsg, expectedMsg, actualMsg + " is not matched with " + expectedMsg);
    }

    @DataProvider(name = "invalidChangePassword")
    public static Object[] getInvalidChangePassword() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ChangePassword> changePasswords = objectMapper.readValue(Common.readFile("/src/test/resources/test_data/invalidChangePassword.json"), new TypeReference<List<ChangePassword>>() {
        });
        return changePasswords.toArray();
    }
}

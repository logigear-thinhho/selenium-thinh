package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.Common;
import helpers.DataHelper;
import models.Register;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.LoginPage;
import page_objects.RegisterPage;

import java.io.IOException;
import java.util.List;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can create an account with valid data")
    public void TC01() {
        System.out.println("TC01 - User can create an account with valid data");

        registerPage.gotoRegisterPage();

        String email = DataHelper.getRandomEmail();
        String password = DataHelper.getRandomText();
        String pid = DataHelper.getRandomNumber();

        registerPage.register(email, password, password, pid);

        String actualMsg = registerPage.getConfirmMessage();
        String expectedMsg = "You're here";

        loginPage.gotoLoginPage();
        loginPage.login(email, password);
        loginPage.logout();

        Assert.assertEquals(actualMsg, expectedMsg, "Registration error!");
    }

    @Test(description = "User can not create an account with blank data")
    public void TC02() {
        registerPage.gotoRegisterPage();

        registerPage.register("", "", "", "");

        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test(description = "User cannot create an account with invalid data", dataProvider = "invalidRegister")
    public void TC03(Register register) {
        registerPage.gotoRegisterPage();

        registerPage.register(register.getEmail(), register.getPassword(), register.getConfirmPassword(), register.getPid());

        String actualMsg = registerPage.getErrorMessage();
        String expectedMsg = register.getMessage();

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @DataProvider(name = "invalidRegister")
    public static Object[] getInvalidLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Register> registers = objectMapper.readValue(Common.readFile("/src/test/resources/test_data/invalidRegister.json"), new TypeReference<List<Register>>() {
        });
        return registers.toArray();
    }
}

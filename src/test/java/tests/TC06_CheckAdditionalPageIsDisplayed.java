package tests;

import helpers.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyTicketPage;

public class TC06_CheckAdditionalPageIsDisplayed extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MyTicketPage myTicketPage = new MyTicketPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(description = "Additional pages display once user logged in")
    public void TC06() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);

        homePage.gotoMyTicketPage();
        String actualMyTicketTitle = myTicketPage.getPageHeader();
        String expectedMyTicketTitle = "Manage Tickets";

        myTicketPage.gotoChangePasswordPage();
        String actualChangePasswordTitle = changePasswordPage.getPageHeader();
        String expectedChangePasswordTitle = "Change password";

        Assert.assertTrue(changePasswordPage.doesMyTicketTabExist(), "My Ticket Tab is not displayed");
        Assert.assertTrue(changePasswordPage.doesChangePasswordTabExist(), "Change Password Tab is not displayed");
        Assert.assertTrue(changePasswordPage.doesLogoutTabExist(), "Logout Tab is not displayed");

        Assert.assertEquals(actualMyTicketTitle, expectedMyTicketTitle, "My Ticket Page Title is not displayed as expected");
        Assert.assertEquals(actualChangePasswordTitle, expectedChangePasswordTitle, "Change Password Page Title is not displayed as expected");
    }
}

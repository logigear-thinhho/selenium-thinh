package tests;

import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class TC14_BookMoreThanTenTickets extends BaseTest {
    HomePage homePage = new HomePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can't book more than 10 tickets")
    public void TC14() {
        String email = DataHelper.getRandomEmail();
        String password = DataHelper.getRandomText();
        String pid = DataHelper.getRandomNumber();

        String departDate = "5/13/2021";
        String departFrom = "Đà Nẵng";
        String arriveAt = "Huế";
        String seatType = "Hard bed";
        String ticketAmount = "10";
        String ticketAmountPlus = "1";

        homePage.gotoRegisterPage();
        registerPage.register(email, password, password, pid);

        registerPage.gotoLoginPage();
        loginPage.login(email, password);
        loginPage.gotoBookTicketPage();

        bookTicketPage.bookTicket(departFrom, arriveAt, seatType, departDate, ticketAmount);
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(departFrom, arriveAt, seatType, departDate, ticketAmountPlus);

        String actualErrorMsg = bookTicketPage.getErrorMessage();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";

        String actualTicketAmountErrorMsg = bookTicketPage.getAmountTicketErrorMsg();
        String expectedTicketAmountErrorMsg = "You have booked 10 tickets. You can book no more.";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
        Assert.assertEquals(actualTicketAmountErrorMsg, expectedTicketAmountErrorMsg, "Error message is not displayed as expected");
    }
}

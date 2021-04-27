package tests;

import helpers.Constant;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;

public class BookTicketTest extends BaseTest{
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod() {
        bookTicketPage.gotoBookTicketPage();
    }

    @Test(description = "User can book a ticket")
    public void TC01() {
        String departDate = "5/8/2021";
        String departFrom = "Đà Nẵng";
        String arriveAt = "Huế";
        String seatType = "Hard bed";
        String ticketAmount = "1";

        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);
    }

}

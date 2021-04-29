package tests;

import helpers.Constant;
import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;

public class BookTicketTest extends BaseTest {
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can book a ticket")
    public void TC01() {
        bookTicketPage.gotoBookTicketPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String departDate = "5/8/2021";
        String departFrom = "Đà Nẵng";
        String arriveAt = "Huế";
        String seatType = "Hard bed";
        String ticketAmount = "1";
        String totalPrice = "250000";

        bookTicketPage.bookTicket(departDate, departFrom, ticketAmount, seatType, arriveAt);

        String actualConfirmMsg = bookTicketPage.getConfirmMessage();
        String expectedConfirmMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualConfirmMsg, expectedConfirmMsg, actualConfirmMsg + " is not matched with " + expectedConfirmMsg);

        String bookDate = DataHelper.getDateFromToday(0);
        String expiredDate = DataHelper.getDateFromToday(3);

        Assert.assertEquals(bookTicketPage.getCellValueByHeader("Depart Date"), departDate, "Depart Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getCellValueByHeader("Depart Station"), departFrom, "Depart Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getCellValueByHeader("Arrive Station"), arriveAt, "Arrive Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getCellValueByHeader("Seat Type"), seatType, "Seat Type is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getCellValueByHeader("Amount"), ticketAmount, "Amount is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getCellValueByHeader("Book Date"), bookDate, "Book Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getCellValueByHeader("Expired Date"), expiredDate, "Expired Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getCellValueByHeader("Total Price"), totalPrice, "Total Price is not displayed as expected");
    }
}

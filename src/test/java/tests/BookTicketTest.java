package tests;

import helpers.Constant;
import helpers.DataHelper;
import helpers.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;
import page_objects.SuccessPage;

public class BookTicketTest extends BaseTest {
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod() {
        bookTicketPage.gotoBookTicketPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
    }

    @Test(description = "User can book a ticket")
    public void TC01() {
        String departDate = "5/8/2021";
        String departFrom = "Đà Nẵng";
        String arriveAt = "Huế";
        String seatType = "Hard bed";
        String ticketAmount = "2";
        bookTicketPage.bookTicket(departDate, departFrom, ticketAmount, seatType, arriveAt);

        SuccessPage successPage = new SuccessPage();
        String actualConfirmMsg = successPage.getConfirmMessage();
        String expectedConfirmMsg = "Ticket Booked Successfully!";
        Assert.assertEquals(actualConfirmMsg, expectedConfirmMsg, "Booked error!");

        String bookDate = DataHelper.getDate(0);
        String expiredDate = DataHelper.getDate(3);

        String actualMsg = bookTicketPage.checkTicket();
        String expectedMsg = "{ Depart Station: " + departFrom + ", Arrive Station: "
                + arriveAt + ", Seat Type: " + seatType + ", Depart Date: " + departDate
                + ", Book Date: " + bookDate + ", Expired Date: " + expiredDate
                + ", Amount: " + ticketAmount + " }";

        Assert.assertEquals(actualMsg, expectedMsg, "Booked error!");
    }
}

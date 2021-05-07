package tests;

import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

public class TC15_BookTicketFromTicketPrice extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "User can open Book ticket page by click on Book ticket link in Ticket price")
    public void TC15() {
        String email = DataHelper.getRandomEmail();
        String password = DataHelper.getRandomText();
        String pid = DataHelper.getRandomNumber();

        String departFrom = "Đà Nẵng";
        String arriveAt = "Huế";
        String seatType = "Hard bed";

        homePage.gotoRegisterPage();
        registerPage.register(email, password, password, pid);

        registerPage.gotoLoginPage();
        loginPage.login(email, password);
        loginPage.gotoTicketPricePage();

        ticketPricePage.selectTrip(departFrom, arriveAt);
        ticketPricePage.clickBookTicketLink(seatType);

        Assert.assertEquals(bookTicketPage.getSelectedTextOfDepartFrom(), departFrom, "Depart From is not match!");
        Assert.assertEquals(bookTicketPage.getSelectedTextOfArriveAt(), arriveAt, "Arrive At is not match!");
        Assert.assertEquals(bookTicketPage.getSelectedTextOfSeatType(), seatType, "Seat Type is not match!");
    }
}

package page_objects;

import helpers.BrowserHelper;
import helpers.ElementHelper;
import models.BookTicket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends BasePage {
    private final By ddlDepartDate = By.name("Date");
    private final By ddlDepartFrom = By.name("DepartStation");
    private final By ddlArriveAt = By.name("ArriveStation");
    private final By ddlSeatType = By.name("SeatType");
    private final By ddlTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.cssSelector("input[type='submit']");

    public WebElement getDdlDepartDate() {
        return BrowserHelper.getDriver().findElement(ddlDepartDate);
    }

    public WebElement getDdlDepartFrom() {
        return BrowserHelper.getDriver().findElement(ddlDepartFrom);
    }

    public WebElement getDdlArriveAt() {
        return BrowserHelper.getDriver().findElement(ddlArriveAt);
    }

    public WebElement getDdlSeatType() {
        return BrowserHelper.getDriver().findElement(ddlSeatType);
    }

    public WebElement getDdlTicketAmount() {
        return BrowserHelper.getDriver().findElement(ddlTicketAmount);
    }

    public WebElement getBtnBookTicket() {
        return BrowserHelper.getDriver().findElement(btnBookTicket);
    }

    public void bookTicket(String departDate, String departFrom, String ticketAmount, String seatType, String arriveAt) {
        BookTicket bookTicket = new BookTicket();

        bookTicket.setDepartDate(departDate);
        bookTicket.setDepartFrom(departFrom);
        bookTicket.setTicketAmount(ticketAmount);
        bookTicket.setSeatType(seatType);
        bookTicket.setArriveAt(arriveAt);

        ElementHelper.selectDropdownByText(getDdlDepartFrom(), departFrom);
        ElementHelper.selectDropdownByText(getDdlDepartDate(), departDate);
        ElementHelper.selectDropdownByText(getDdlTicketAmount(), ticketAmount);
        ElementHelper.selectDropdownByText(getDdlSeatType(), seatType);
        ElementHelper.selectDropdownByText(getDdlArriveAt(), arriveAt);


        ElementHelper.scrollToView(getBtnBookTicket());
        this.getBtnBookTicket().click();
    }

    public String checkTicket() {
        SuccessPage successPage = new SuccessPage();
        return "{ Depart Station: " + successPage.getTextByHead("Depart Station") + ", Arrive Station: " + successPage.getTextByHead("Arrive Station")
                + ", Seat Type: " + successPage.getTextByHead("Seat Type") + ", Depart Date: " + successPage.getTextByHead("Depart Date")
                + ", Book Date: " + successPage.getTextByHead("Book Date") + ", Expired Date: " + successPage.getTextByHead("Expired Date")
                + ", Amount: " + successPage.getTextByHead("Amount") + " }";
    }
}

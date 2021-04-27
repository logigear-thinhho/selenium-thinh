package page_objects;

import helpers.BrowserHelper;
import helpers.Constant;
import helpers.ElementHelper;
import helpers.Wait;
import models.BookTicket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        BookTicket bookTicket = new BookTicket();

        bookTicket.setDepartDate(departDate);
        bookTicket.setDepartFrom(departFrom);
        bookTicket.setArriveAt(arriveAt);
        bookTicket.setSeatType(seatType);
        bookTicket.setTicketAmount(ticketAmount);

        ElementHelper.selectDropdownByText(getDdlDepartDate(),departDate);
        ElementHelper.selectDropdownByText(getDdlDepartFrom(),departFrom);
        Wait.untilAbc(ddlArriveAt,Constant.SHORT_TIME);
        ElementHelper.selectDropdownByText(getDdlArriveAt(),arriveAt);
        ElementHelper.selectDropdownByText(getDdlSeatType(),seatType);
        ElementHelper.selectDropdownByText(getDdlTicketAmount(),ticketAmount);

        ElementHelper.scrollToView(getBtnBookTicket());
        this.getBtnBookTicket().click();
    }
}

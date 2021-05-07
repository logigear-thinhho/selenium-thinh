package page_objects;

import helpers.BrowserHelper;
import helpers.Constant;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends BasePage {
    private final By ddlDepartDate = By.name("Date");
    private final By ddlDepartFrom = By.name("DepartStation");
    private final By ddlArriveAt = By.name("ArriveStation");
    private final By ddlSeatType = By.name("SeatType");
    private final By ddlTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.cssSelector("input[type='submit']");
    private final By lblConfirmMessage = By.cssSelector("#content h1");
    private final By lblErrorMessage = By.cssSelector(".message.error");
    private final By lblTicketAmountErrorMsg = By.className("validation-error");

    private WebElement getDdlDepartDate() {
        return BrowserHelper.getDriver().findElement(ddlDepartDate);
    }

    private WebElement getDdlDepartFrom() {
        return BrowserHelper.getDriver().findElement(ddlDepartFrom);
    }

    private WebElement getDdlArriveAt() {
        return BrowserHelper.getDriver().findElement(ddlArriveAt);
    }

    private WebElement getDdlSeatType() {
        return BrowserHelper.getDriver().findElement(ddlSeatType);
    }

    private WebElement getDdlTicketAmount() {
        return BrowserHelper.getDriver().findElement(ddlTicketAmount);
    }

    private WebElement getBtnBookTicket() {
        return BrowserHelper.getDriver().findElement(btnBookTicket);
    }

    private WebElement getLblConfirmMessage() {
        return BrowserHelper.getDriver().findElement(lblConfirmMessage);
    }

    private WebElement getLblErrorMessage() {
        return BrowserHelper.getDriver().findElement(lblErrorMessage);
    }

    private WebElement getLblTicketAmountErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblTicketAmountErrorMsg);
    }

    public String getConfirmMessage() {
        return this.getLblConfirmMessage().getText();
    }

    public String getErrorMessage() {
        return this.getLblErrorMessage().getText();
    }

    public String getAmountTicketErrorMsg() {
        return this.getLblTicketAmountErrorMsg().getText();
    }

    public void bookTicket(String departFrom, String arriveAt, String seatType, String departDate, String ticketAmount) {
        ElementHelper.selectDropdownByText(getDdlDepartFrom(), departFrom);
        ElementHelper.selectDropdownByText(getDdlDepartDate(), departDate);
        ElementHelper.scrollToView(getBtnBookTicket());
        ElementHelper.selectDropdownByText(getDdlTicketAmount(), ticketAmount);
        Wait.notStalenessOf(getDdlSeatType(), Constant.SHORT_TIME);
        ElementHelper.selectDropdownByText(getDdlSeatType(), seatType);
        ElementHelper.selectDropdownByText(getDdlArriveAt(), arriveAt);

        this.getBtnBookTicket().click();
    }

    public String getSelectedTextOfDepartFrom() {
        return ElementHelper.getDropDownSelectedValue(getDdlDepartFrom());
    }

    public String getSelectedTextOfArriveAt() {
        return ElementHelper.getDropDownSelectedValue(getDdlArriveAt());
    }

    public String getSelectedTextOfSeatType() {
        return ElementHelper.getDropDownSelectedValue(getDdlSeatType());
    }
}

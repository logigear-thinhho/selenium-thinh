package page_objects;

import helpers.BrowserHelper;
import helpers.ElementHelper;
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
    private final String dynamicTableCell = "//table/tbody/tr/td[count(//table/tbody/tr/th[.='%s']/preceding-sibling::th)+1]";

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

    private WebElement getCellByHeader(String header) {
        return BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicTableCell, header)));
    }

    public String getConfirmMessage() {
        return this.getLblConfirmMessage().getText();
    }

    public String getCellValueByHeader(String header) {
        return getCellByHeader(header).getText();
    }

    public void bookTicket(String departDate, String departFrom, String ticketAmount, String seatType, String arriveAt) {
        ElementHelper.selectDropdownByText(getDdlDepartFrom(), departFrom);
        ElementHelper.selectDropdownByText(getDdlDepartDate(), departDate);
        ElementHelper.selectDropdownByText(getDdlTicketAmount(), ticketAmount);
        ElementHelper.selectDropdownByText(getDdlSeatType(), seatType);
        ElementHelper.selectDropdownByText(getDdlArriveAt(), arriveAt);

        ElementHelper.scrollToView(getBtnBookTicket());
        this.getBtnBookTicket().click();
    }
}

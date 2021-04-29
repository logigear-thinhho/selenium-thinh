package page_objects;

import helpers.BrowserHelper;
import helpers.Constant;
import helpers.ElementHelper;
import helpers.Wait;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage {
    private final By lblErrorMsg = By.cssSelector(".error.message");
    String ticketInfo = "//tr//td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']";
    String btnCancel = "//tr//td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::input[@value='Cancel']";

    private WebElement getLblErrorMsg() {
        return BrowserHelper.getDriver().findElement(lblErrorMsg);
    }

    public String getErrorMsg() {
        return this.getLblErrorMsg().getText();
    }

    public void cancelTicket(Ticket ticket) {
        By getBtnCancel = By.xpath(String.format(btnCancel
                , ticket.getDepartStation()
                , ticket.getDepartArrive()
                , ticket.getSeatType()
                , ticket.getDepartDate()
                , ticket.getAmountTicket()));

        BrowserHelper.getDriver().findElement(getBtnCancel).click();
        Wait.untilAlertPopupExist(Constant.SHORT_TIME);
        BrowserHelper.acceptAlert();
    }

    public boolean doesTicketExist(Ticket ticket) {
        Wait.untilElementExist(lblErrorMsg,Constant.SHORT_TIME);

        By getTicketInfo = By.xpath(String.format(ticketInfo
                , ticket.getDepartStation()
                , ticket.getDepartArrive()
                , ticket.getSeatType()
                , ticket.getDepartDate()
                , ticket.getAmountTicket()));

        return !BrowserHelper.getDriver().findElements(getTicketInfo).isEmpty();
    }

}

package page_objects;

import helpers.BrowserHelper;
import models.Ticket;
import org.openqa.selenium.By;

public class MyTicketPage extends BasePage {
    String ticketInfo = "//tr//td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']";
    String btnCancel = "//tr//td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::td[text()='%s']//following::input[@value='Cancel']";

    public void cancelTicket(Ticket ticket) {
        By getBtnCancel = By.xpath(String.format(btnCancel
                , ticket.getDepartStation()
                , ticket.getDepartArrive()
                , ticket.getSeatType()
                , ticket.getDepartDate()
                , ticket.getAmountTicket()));

        if (BrowserHelper.getDriver().findElements(getBtnCancel).size() != 0) {
            BrowserHelper.getDriver().findElement(getBtnCancel).click();
            BrowserHelper.getDriver().switchTo().alert().accept();
        }
    }

    public boolean checkTicketExist(Ticket ticket) {
        By getTicketInfo = By.xpath(String.format(ticketInfo
                , ticket.getDepartStation()
                , ticket.getDepartArrive()
                , ticket.getSeatType()
                , ticket.getDepartDate()
                , ticket.getAmountTicket()));

        return !BrowserHelper.getDriver().findElements(getTicketInfo).isEmpty();
    }

}

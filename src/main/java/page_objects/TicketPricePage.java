package page_objects;

import helpers.*;
import org.openqa.selenium.By;

public class TicketPricePage extends BasePage {
    private final String dynamicLinkCheckPrice = "//li[text()='%s to %s']//ancestor::tr//a";
    private final String dynamicLinkBookTicket = "//td[text() = '%s' and @class='NoBorder']//parent::tr//a";
    private final By pageHeader = By.cssSelector("#content h1");

    public void selectTrip(String departFrom, String arriveAt) {
        ElementHelper.scrollToView(BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicLinkCheckPrice, departFrom, arriveAt))));
        LogHelper.info(BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicLinkCheckPrice, departFrom, arriveAt))).getText());
        BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicLinkCheckPrice, departFrom, arriveAt))).click();
    }

    public void clickBookTicketLink(String seatType) {
        Wait.untilElementExist(pageHeader, Constant.SHORT_TIME);
        BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicLinkBookTicket, seatType))).click();
    }
}

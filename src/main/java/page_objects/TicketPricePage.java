package page_objects;

import helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends BasePage {
    private final String dynamicLinkCheckPrice = "//table[@class='NoBorder']//tr//li[text()='%s to %s']//ancestor::tr//a";
    private final String dynamicLinkBookTicket = "//table[@class='NoBorder']//tr//td[text() = '%s' and @class='NoBorder']//parent::tr//a";
    private final By pageHeader = By.cssSelector("#content h1");

    private WebElement getCheckPriceLink(String departFrom, String arriveAt) {
        return BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicLinkCheckPrice, departFrom, arriveAt)));
    }

    public void selectTrip(String departFrom, String arriveAt) {
        ElementHelper.scrollToView(getCheckPriceLink(departFrom, arriveAt));
        getCheckPriceLink(departFrom, arriveAt).click();
    }

    public void clickBookTicketLink(String seatType) {
        Wait.untilElementExist(pageHeader, Constant.SHORT_TIME);
        BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicLinkBookTicket, seatType))).click();
    }
}

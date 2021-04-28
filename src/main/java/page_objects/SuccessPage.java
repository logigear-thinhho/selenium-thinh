package page_objects;

import helpers.BrowserHelper;
import helpers.Constant;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuccessPage extends BasePage {
    private final By lblConfirmMessage = By.cssSelector("#content h1");

    public WebElement getTdTextByHeader(String header) {
        String tdText = "//table/tbody/tr/td[count(//table/tbody/tr/th[.='%s']/preceding-sibling::th)+1]";
        return BrowserHelper.getDriver().findElement(By.xpath(String.format(tdText, header)));
    }

    public String getTextByHead(String header) {
        return getTdTextByHeader(header).getText();
    }

    public WebElement getLblConfirmMessage(){
        return BrowserHelper.getDriver().findElement(lblConfirmMessage);
    }

    public String getConfirmMessage(){
        return this.getLblConfirmMessage().getText();
    }
}

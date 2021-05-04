package tests;

import helpers.BrowserHelper;
import helpers.Constant;
import helpers.LogHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        LogHelper.info("Pre-condition");
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void afterMethod() {
        LogHelper.info("Post-condition");
        BrowserHelper.quitBrowser();
    }
}

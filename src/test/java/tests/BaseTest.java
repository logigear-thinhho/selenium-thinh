package tests;

import helpers.BrowserHelper;
import helpers.Constant;
import helpers.LogHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser) {
        LogHelper.info("Pre-condition");
        BrowserHelper.startBrowser(BrowserHelper.DriverType.valueOf(browser.toUpperCase()));
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void afterMethod() {
        LogHelper.info("Post-condition");
        BrowserHelper.quitBrowser();
    }
}

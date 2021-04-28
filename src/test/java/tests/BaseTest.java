package tests;

import helpers.BrowserHelper;
import helpers.Constant;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeTest
    public void beforeTest() {
        System.out.println("Pre-condition");
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Post-condition");
        BrowserHelper.quitBrowser();
    }


}

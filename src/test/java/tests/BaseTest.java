package tests;

import helpers.BrowserHelper;
import helpers.Common;
import helpers.Constant;
import driver_manager.DriverManager;
import driver_manager.DriverManagerFactory;
import driver_manager.DriverType;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {
//    @BeforeTest
//    public void beforeTest() {
//        DriverManager driverManager;
//        System.out.println("Pre-condition");
//        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
//        Constant.WEBDRIVER = driverManager.getWebDriver();
//        Common.openRailway();
//    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Pre-condition");
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        Common.openRailway();
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }


}

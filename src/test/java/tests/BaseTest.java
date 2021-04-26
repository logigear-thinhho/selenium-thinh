package tests;

import helpers.Common;
import helpers.Constant;
import driver_manager.DriverManager;
import driver_manager.DriverManagerFactory;
import driver_manager.DriverType;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        DriverManager driverManager;
        System.out.println("Pre-condition");
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        Constant.WEBDRIVER = driverManager.getWebDriver();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }


}

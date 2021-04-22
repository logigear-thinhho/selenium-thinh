package tests;

import common.constants.Constant;
import common.driver_manager.DriverManager;
import common.driver_manager.DriverManagerFactory;
import common.driver_manager.DriverType;
import common.helpers.Helper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    JavascriptExecutor js;
    DriverManager driverManager;

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        Constant.WEBDRIVER = driverManager.getWebDriver();
        js = (JavascriptExecutor) Constant.WEBDRIVER;
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}

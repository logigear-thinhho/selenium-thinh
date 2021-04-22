package common.driver_manager;

import common.constants.Constant;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{
    @Override
    public void createWebDriver(){
        FirefoxOptions options = new FirefoxOptions();
        Constant.WEBDRIVER = new FirefoxDriver(options);
    }
}

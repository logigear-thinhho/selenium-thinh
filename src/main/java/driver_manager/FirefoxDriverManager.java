package driver_manager;

import helpers.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        Constant.WEBDRIVER = new FirefoxDriver(options);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
    }
}

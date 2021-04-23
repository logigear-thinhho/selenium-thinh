package driver_manager;

import helpers.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class InternetExplorerDriverManager extends DriverManager {

    @Override
    public void createWebDriver() {
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions options = new InternetExplorerOptions();
        Constant.WEBDRIVER = new InternetExplorerDriver(options);
    }
}

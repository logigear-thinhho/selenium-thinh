package common.driver_manager;

import common.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Constant.WEBDRIVER = new ChromeDriver(options);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        Constant.WEBDRIVER.manage().window().maximize();
    }

}

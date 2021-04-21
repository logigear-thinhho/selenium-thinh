package common.driver_manager;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverType type){
        DriverManager driverManager;
        switch (type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return driverManager;
    }
}

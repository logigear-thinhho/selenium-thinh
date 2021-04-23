package helpers;

public class Common {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public void openRailway() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }


}

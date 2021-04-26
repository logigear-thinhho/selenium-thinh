package helpers;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Common {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public void openRailway() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }




}

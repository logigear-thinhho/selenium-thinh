package helpers;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Common {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static void openRailway() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public static void navigateToUrl(String url) {
        Constant.WEBDRIVER.get(url);
    }

    public static File readFile(String fileName) {
        File file = new File(Common.getProjectPath() + fileName);
        if (file.exists()) {
            return file;
        }
        return null;
    }

}

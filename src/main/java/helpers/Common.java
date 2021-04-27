package helpers;

import java.io.File;

public class Common {
    public static File readFile(String fileName) {
        File file = new File(System.getProperty("user.dir") + fileName);
        if (file.exists()) {
            return file;
        }
        return null;
    }
}

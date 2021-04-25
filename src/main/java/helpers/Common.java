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

    public static Object[][] getData(String filepath, String TCname) throws IOException {
        Object[][] data;
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        JsonElement jsonElement = new JsonParser().parse(br);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray(TCname);
        return data = convertJsonArrayToObjectArray(jsonArray);
    }

    public static Object[][] convertJsonArrayToObjectArray(JsonArray jsonArray) {
        Object[][] data = new Object[0][1];
        Gson gson = new Gson();
        int index = 0;
        if (jsonArray.size() > 0) {
            data = new Object[jsonArray.size()][1];
            for (JsonElement obj : jsonArray) {
                Hashtable<String, String> hashtable = new Hashtable<String, String>();
                data[index][0] = gson.fromJson(obj, hashtable.getClass());
                index++;
            }
        }
        return data;
    }


}

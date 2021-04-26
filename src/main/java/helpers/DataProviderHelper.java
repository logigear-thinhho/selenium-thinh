package helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Login;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class DataProviderHelper {
    @DataProvider(name = "valid-login")
    public static Object[] getValidLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Login> logins = objectMapper.readValue(Common.readFile("/src/test/resources/test_data/valid-login.json"), new TypeReference<List<Login>>() {
        });
        return logins.toArray();
    }

    @DataProvider(name = "invalid-login")
    public static Object[] getInvalidLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Login> logins = objectMapper.readValue(Common.readFile("/src/test/resources/test_data/invalid-login.json"), new TypeReference<List<Login>>() {
        });
        return logins.toArray();
    }
}

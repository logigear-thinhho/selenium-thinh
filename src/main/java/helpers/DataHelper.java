package helpers;

import com.github.javafaker.Faker;

public class DataHelper {
    private static final Faker faker = new Faker();

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomText() {
        return faker.letterify("????????");
    }
}

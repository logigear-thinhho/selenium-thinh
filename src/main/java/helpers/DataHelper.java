package helpers;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataHelper {
    private static final Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomText() {
        return faker.letterify("????????");
    }

    public static String getRandomNumber() {
        return faker.numerify("########");
    }

    public static String getDate(int num) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, num);
        return new SimpleDateFormat("M/d/yyyy").format(cal.getTime());
    }
}

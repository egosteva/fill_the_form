package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DynamicDataUtils {
    public static void main(String[] args) {
        String[] genders = {"Male", "Female", "Other"};
        System.out.println(getRandomItemFromArray(genders));
        System.out.println(getRandomFirstName());
        System.out.println(getRandomLastName());
        System.out.println(getRandomEmail());
        System.out.println(getRandomPhone());

        Date fakerDateOfBirthday = new Faker(new Locale("en")).date().birthday();

        String dayOfBirth = new SimpleDateFormat("d").format(fakerDateOfBirthday);
        String monthOfBirth = new SimpleDateFormat("MMMM").format(fakerDateOfBirthday);
        String yearOfBirth = new SimpleDateFormat("yyyy").format(fakerDateOfBirthday);
        System.out.println(dayOfBirth + monthOfBirth + yearOfBirth);
    }


    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }

    public static String getRandomFirstName() {
        return new Faker(new Locale("en")).name().firstName();
    }

    public static String getRandomLastName() {
        return new Faker(new Locale("en")).name().lastName();
    }

    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomPhone() {
        String phoneNumberWithSymbol = new Faker(new Locale("ru")).phoneNumber().phoneNumber();

        return phoneNumberWithSymbol.replaceAll("[^\\d]", "").substring(1);
    }

    public static String getRandomAddress() {
        return new Faker(new Locale("en")).address().fullAddress();
    }

    static Date randomDateOfBirth = new Faker().date().birthday();
    public static String dayOfBirth = new SimpleDateFormat("d").format(randomDateOfBirth),
            monthOfBirth = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(randomDateOfBirth),
            yearOfBirth = new SimpleDateFormat("yyyy").format(randomDateOfBirth);


}

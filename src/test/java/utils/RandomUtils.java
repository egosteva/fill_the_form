package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(1, 10));
        System.out.println(getRandomEmail());

        String[] names = {"a", "b", "c", "d"};
        System.out.println(getRandomItemFromArray(names));

        String[] genders = {"Male", "Female", "Other"};
        System.out.println(getRandomItemFromArray(genders));

        System.out.println(getRandomName());
    }

    public static String getRandomString(int lenght) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@qa.guru";
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }

    //   public static String getRandomName() {
    //       Faker faker = new Faker(new Locale("en"));
    //
    //       return faker.name().firstName();
    //   }

    public static String getRandomName() {
        return new Faker().name().firstName();
    }
}
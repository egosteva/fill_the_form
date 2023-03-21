package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import static utils.RandomUtils.getRandomItemFromArray;

public class DynamicTestData {
    //   public static void main(String[] args) {
    //   String[] genders = {"Male", "Female", "Other"};
    //    Date fakerDateOfBirthday = new Faker(new Locale("en")).date().birthday();
    //   String dayOfBirth = new SimpleDateFormat("d").format(fakerDateOfBirthday);
    //   String monthOfBirth = new SimpleDateFormat("MMMM").format(fakerDateOfBirthday);
    //   String yearOfBirth = new SimpleDateFormat("yyyy").format(fakerDateOfBirthday);
    //   System.out.println(dayOfBirth + monthOfBirth + yearOfBirth);


    public static String[] genders = {"Male", "Female", "Other"};
    public static String[] hobbies = {"Sports", "Reading", "Music"};
    public static String[] subjects = {"Maths", "Computer Science", "History", "English", "Arts", "Biology", "Hindi"};


    public static String firstName = new Faker(new Locale("en")).name().firstName(),
            lastName = new Faker(new Locale("en")).name().lastName(),
            email = new Faker().internet().emailAddress(),
            gender = getRandomItemFromArray(genders);

    static String phoneNumberWithSymbols = new Faker(new Locale("ru")).phoneNumber().phoneNumber();
    public static String phone = phoneNumberWithSymbols.replaceAll("[^\\d]", "").substring(1);

    public static String subject1 = getRandomItemFromArray(subjects),
            subject2 = getRandomItemFromArray(subjects),
            hobby = getRandomItemFromArray(hobbies),
            currentAddress = new Faker(new Locale("en")).address().fullAddress();

    static Date randomDateOfBirth = new Faker().date().birthday();
    public static String dayOfBirth = new SimpleDateFormat("d").format(randomDateOfBirth),
            monthOfBirth = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(randomDateOfBirth),
            yearOfBirth = new SimpleDateFormat("yyyy").format(randomDateOfBirth);
}

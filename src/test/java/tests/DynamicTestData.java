package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import static utils.RandomUtils.getRandomItemFromArray;

public class DynamicTestData {
    public static String[] genderList = {"Male", "Female", "Other"},
            hobbyList = {"Sports", "Reading", "Music"},
            subjectList = {"Maths", "Computer Science", "History", "English", "Arts", "Biology", "Hindi"};

    public static String firstName = new Faker(new Locale("en")).name().firstName(),
            lastName = new Faker().name().lastName(),
            email = new Faker().internet().emailAddress(),
            gender = getRandomItemFromArray(genderList);

    static String phoneNumberWithSymbols = new Faker(new Locale("ru")).phoneNumber().phoneNumber();
    public static String phone = phoneNumberWithSymbols.replaceAll("[^\\d]", "").substring(1);

    static Date randomDateOfBirth = new Faker().date().birthday();
    public static String dayOfBirth = new SimpleDateFormat("d").format(randomDateOfBirth),
            monthOfBirth = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(randomDateOfBirth),
            yearOfBirth = new SimpleDateFormat("yyyy").format(randomDateOfBirth);

    public static String subject = getRandomItemFromArray(subjectList),
            hobby = getRandomItemFromArray(hobbyList),
            imageName = "profile.jpeg",
            currentAddress = new Faker(new Locale("en")).address().fullAddress();

    static Map<String, String[]> mapStateAndCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
    public static String state = getRandomItemFromArray(mapStateAndCity.keySet().toArray(new String[0])),
    city = getRandomItemFromArray(mapStateAndCity.get(state));
}

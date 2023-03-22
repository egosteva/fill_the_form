package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

public class PracticeFormWithFakerTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    
    @Test
    void fillPracticeFormTest() {
        Faker faker = new Faker(new Locale("en"));
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                currentAddress = faker.address().fullAddress(),
                phone = "+7" + faker.number().numberBetween(100000, 99999);

        String gender = "Male";
        String dayOfBirth = "17";
        String monthOfBirth = "May";
        String yearOfBirth = "2008";
        String subject1 = "Maths";
        String subject2 = "Computer Science";
        String hobby = "Music";
        String imageName = "profile.jpeg";
        String state = "Haryana";
        String city = "Panipat";

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject1)
                .setSubject(subject2)
                .setHobby(hobby)
                .uploadPicture(imageName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.checkResultsModalAppears()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject1 + ", " + subject2)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", imageName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}
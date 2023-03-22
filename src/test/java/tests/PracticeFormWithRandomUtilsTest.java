package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;

public class PracticeFormWithRandomUtilsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillPracticeFormTest() {
        String[] genders = {"Male", "Female", "Other"};
        String firstName = getRandomString(10),
                lastName = getRandomString(10),
                email = getRandomEmail(),
                gender = getRandomItemFromArray(genders);

        String phone = "9014045055";
        String dayOfBirth = "17";
        String monthOfBirth = "May";
        String yearOfBirth = "2008";
        String subject1 = "Maths";
        String subject2 = "Computer Science";
        String hobby = "Music";
        String currentAddress = "NY";
        String imageName = "profile.jpeg";
        String state = "Haryana";
        String city = "Panipat";

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(TestData.lastName)
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
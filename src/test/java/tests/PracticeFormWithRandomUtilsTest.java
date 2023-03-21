package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.DynamicDataUtils.*;

public class PracticeFormWithRandomUtilsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillPracticeFormTest() {
        String[] genders = {"Male", "Female", "Other"};
        String[] hobbies = {"Sports", "Reading", "Music"};
        String[] subjects =  {"Maths", "Computer Science", "History", "English", "Arts", "Biology", "Hindi"};
        String firstName = getRandomFirstName(),
                lastName = getRandomLastName(),
                email = getRandomEmail(),
                gender = getRandomItemFromArray(genders),
                phone = getRandomPhone(),
                subject1 = getRandomItemFromArray(subjects),
                subject2 = getRandomItemFromArray(subjects),
                hobby = getRandomItemFromArray(hobbies),
                currentAddress = getRandomAddress(),
                imageName = "profile.jpeg",
                state = "Haryana",
                city = "Panipat";

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
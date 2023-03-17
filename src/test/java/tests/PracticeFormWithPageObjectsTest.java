package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithPageObjectsTest extends TestBase {

    @Test
    void fillFormTest() {
        String firstName = "Andrey";
        String lastName = "Mokeev";
        String email = "mokeev_a@somemail.ru";
        String gender = "Male";
        String phone = "9014045055";
        String dayOfBirth = "17";
        String monthOfBirth = "May";
        String yearOfBirth = "2008";
        String subject1 = "Maths";
        String subject2 = "Computer Science";
        String hobby = "Music";
        String currentAddress = "NY";
        String imageName = "0d6de7af1701b7f6ff551d4474ced401.jpeg";
        String state = "Haryana";
        String city = "Panipat";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject1)
                .setSubject(subject2)
                .setHobby(hobby)
                .setCurrentAddress(currentAddress)
                .uploadPicture(imageName)
                .setState(state)
                .setCity(city)
                .submit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subject1 + ", " + subject2)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", imageName)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }
}
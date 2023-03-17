package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithPageObjectsTest extends TestBase {

    @Test
    void fillFormTest() {
        String userName = "Andrey";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Mokeev")
                .setUserEmail("mokeev_a@somemail.ru")
                .setGender("Male")
                .setPhoneNumber("9014045055")
                .setBirthDate("17", "4", "2008")
                .setSubject("Maths")
                .setSubject("Computer Science")
                .setHobby("Music");

        // Picture
        $("#uploadPicture").uploadFromClasspath("img/0d6de7af1701b7f6ff551d4474ced401.jpeg");

        //  Current Address
        $("#currentAddress").setValue("NY");

        // State and City
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();

        // Submit
        $("#submit").click();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName +" Mokeev")
                .verifyResult("Student Email", "mokeev_a@somemail.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Date of Birth", "17 May,2008")
                .verifyResult("Subjects", "Maths, Computer Science")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "0d6de7af1701b7f6ff551d4474ced401.jpeg")
                .verifyResult("Address", "NY")
                .verifyResult("State and City", "Haryana Panipat");
    }
}
package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithPageObjects {
    RegistrationPage registrationPage = new RegistrationPage();


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String userName = "Andrey";

        registrationPage.openPage();
        registrationPage.setFirstName(userName);
        registrationPage.setLastName("Mokeev");
        registrationPage.setUserEmail("mokeev_a@somemail.ru");
        registrationPage.setGender("Male");
        registrationPage.setPhoneNumber("9014045055");


        // Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-dropdown-container--select").click();
        $(".react-datepicker__year-select").selectOptionByValue("2008");
        $(".react-datepicker__month-dropdown-container--select").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__day--017").click();

        // Subjects
        $("#subjectsInput").setValue("Mat");
        $(byText("Maths")).click();

        // Hobbies
        $("#hobbies-checkbox-3").parent().click();

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
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Mokeev"), text("mokeev_a@somemail.ru"), text("Male"),
                text("9014045055"), text("17 May,2008"), text("Maths"), text("Music"), text("0d6de7af1701b7f6ff551d4474ced401.jpeg"),
                text("NY"), text("Haryana"), text("Panipat"));
    }
}
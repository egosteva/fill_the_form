package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderChoice = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            subjectDropdown = $(".subjects-auto-complete__menu"),
            hobbyChoice = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            stateChoice = $("#state"),
            cityChoice = $("#city");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    //   public RegistrationPage clearLastName() {
    //      lastNameInput.clear();
    //
    //       return this;
    //  }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderChoice.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value);
        subjectDropdown.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbyChoice.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateChoice.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityChoice.click();
        $(byText(value)).click();

        return this;
    }


    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }


}

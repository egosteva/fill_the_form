package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderChoice = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber");


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

    public RegistrationPage clearLastName() {
        lastNameInput.clear();

        return this;
    }

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
}

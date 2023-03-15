package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest(){
        open("/text-box");

        $("#userName").setValue("Andrey Fetisov");
        $("#userEmail").setValue("fetisov@somemail.ru");
        $("#currentAddress").setValue("Moscow, Arbat St");
        $("#permanentAddress").setValue("NY");
        $("#submit").click();

        $("#submit").click();
        $("#output").shouldHave(text("Andrey Fetisov"), text("fetisov@somemail.ru"),
                text("Moscow, Arbat St"), text("NY"));
    }
}

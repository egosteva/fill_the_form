package examples;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void CssXpathExamples(){
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("id=email");
        $x("//*[@id='email']").setValue("1");
        $x("//input[@id='email']").setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name=email]").setValue("2");
        $(byName("email")).setValue("2");

        // <input type="email" class="inputtext login_form_input_box">
        $("[class=login_form_input_box]").setValue("3");
        $(".login_form_input_box").setValue("3");
        $(".inputtext.login_form_input_box").setValue("3");
        $("input.inputtext.login_form_input_box").setValue("3");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("3");

        // <div class="inputtext">
        //      <input type="email" class="inputtext login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box").setValue("4");
        $(".inputtext").$("login_form_input_box").setValue("4");

        // <div>Hello, qa.guru!</div>
        // поиск по тексту
        $x("//div[text()='Hello, qa.guru!']").click();
        $(byText("Hello, qa.guru!")).click();
        $(withText("llo, qa.gur")).click();
    }
}

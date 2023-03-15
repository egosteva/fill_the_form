package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__year-dropdown-container--select").click();
        $(".react-datepicker__year-select").selectOptionByValue(year); // 2008
        $(".react-datepicker__month-dropdown-container--select").click();
        $(".react-datepicker__month-select").selectOptionByValue(month); //4
        $(".react-datepicker__day--0" + day).click(); // 17
    }
}

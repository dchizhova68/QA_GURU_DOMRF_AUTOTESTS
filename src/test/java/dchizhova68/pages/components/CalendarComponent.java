package dchizhova68.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    public void setDate (String dayFrom,String dayTo, String month, String year) {

        while (!($$(".dp__month_year_select").get(0).getText().equals(month) && ($$(".dp__month_year_select").get(1).getText().equals(year)))) {
            $(byAttribute("aria-label", "Previous month")).click();
        }
        $(".dp__menu").$$(".dp__cell_inner:not(.dp__cell_offset)").findBy(text(dayFrom)).click();
        $(".dp__menu").$$(".dp__cell_inner:not(.dp__cell_offset)").findBy(text(dayTo)).click();

    }

}

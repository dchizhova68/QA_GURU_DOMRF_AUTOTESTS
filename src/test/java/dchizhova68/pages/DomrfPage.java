package dchizhova68.pages;


import com.codeborne.selenide.SelenideElement;
import dchizhova68.pages.components.CalendarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.CollectionCondition.*;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

public class DomrfPage {
    private SelenideElement
            burgerButton = $(".burger-button"),
            rightMenuLocator = $("#menu-burger-nav"),
            phoneNumber = $("#general").$(byText("Телефон")).sibling(0),
            newsSearchIcon = $(".news-search__icon"),
            searchInput = $("input.input__field"),
            calendarInput = $(byAttribute("placeholder", "Выберите дату")),
            applyButton = $(byTagAndText("button", "Применить"));

    private ElementsCollection
            newsList = $$(".n-news-list"),
            newsTitleList = $$(".n-news-list__title"),
            headerNavItemList = $(".header__nav").$$("a"),
            mainNavItemList = $(".main-nav").$$("a");

    CalendarComponent calendar = new CalendarComponent();

    @Step("Открываем главную страницу")
    public DomrfPage openPage() {
        open("/");
        return this;
    }

    @Step("Открываем правое боковое меню")
    public DomrfPage openRightMenu() {
        burgerButton.click();
        return this;
    }

    @Step("Проверяем, что правое боковое меню открылось")
    public DomrfPage checkRightMenuOpening() {
        rightMenuLocator.should(appear);
        return this;
    }

    @Step("Кликаем по пункту меню {itemMenu}")
    public DomrfPage clickItemMenu(String itemMenu) {
        rightMenuLocator.$(byText(itemMenu)).click();
        return this;
    }

    @Step("Проверяем номер телефона")
    public DomrfPage checkPhoneNumber() {
        phoneNumber.shouldHave(text("+7 (495) 775-47-40"));
        return this;
    }

    @Step("Перейти по ссылке {link}")
    public DomrfPage openLink(String link) {
        $(byTagAndText("a", link)).click();
        return this;
    }

    @Step("Вводим строку для поиска новостей")
    public DomrfPage setSearchValue(String searchValue) {
        newsSearchIcon.click();
        searchInput.setValue(searchValue).pressEnter();
        return this;
    }

    @Step("Задаем период публикации новости")
    public DomrfPage setDatePublication(String dayFrom, String dayTo, String month, String year) {
        calendarInput.click();
        calendar.setDate(dayFrom, dayTo, month, year);
        applyButton.click();
        return this;
    }

    @Step("Проверяем найденные новости")
    public DomrfPage checkNews(String newstitle) {
        newsList.shouldHave(sizeGreaterThan(0));
        newsTitleList.shouldHave(itemWithText(newstitle));
        return this;
    }

    @Step("Открываем раздел сайта")
    public DomrfPage openItemOfHeaderMenu(String itemOfHeaderMenu) {
        headerNavItemList.findBy(text(itemOfHeaderMenu)).click();
        return this;
    }

    @Step("Проверяем верхнее меню")
    public DomrfPage checkHeaderMenu(List<String> mainMenuItems) {
        mainNavItemList.shouldHave(textsInAnyOrder(mainMenuItems));
        return this;
    }


    @Step("Проверяем ссылки на социальные сети")
    public DomrfPage checkSocialsLinks() {
        $(".footer__socials").$$("a.socials__item").shouldHave(size(3));
        return this;
    }
}

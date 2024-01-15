package dchizhova68;

import dchizhova68.pages.DomrfPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DomrfAutotest extends TestBase {
    final String itemRightMenu = "Контакты";
    final String linkName = "Все новости";
    final String searchValue = "выставка";
    final String newstitle = "ЩЛЗ выпустил более 4000 лифтов для обновления жилого фонда России";
    final String itemOfHeaderMenu = "Для регионов";
    final String dayPublicationFrom = "29";
    final String dayPublicationTo = "30";
    final String monthPublication = "Декабрь";
    final String yearPublication = "2023";
    final List<String> list = Arrays.asList("Городская среда", "Финансирование инфраструктуры", "Земля и недвижимость", "Аналитика", "Льготы");
    DomrfPage domrfPage = new DomrfPage();

    @Test
    @DisplayName("Проверка открытия правой боковой панели с меню")
    void openRightMenuTest() {
        domrfPage.openPage()
                .openRightMenu()
                .checkRightMenuOpening();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Проверка страницы Контакты")
    void pageContactsShouldHavePhoneNumberTest() {
        domrfPage.openPage()
                .openRightMenu()
                .clickItemMenu(itemRightMenu)
                .checkPhoneNumber();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Проверка поиска новостей")
    void newsSearch() {
        domrfPage.openPage()
                .openLink(linkName)
                .setSearchValue(searchValue)
                .setDatePublication(dayPublicationFrom, dayPublicationTo, monthPublication, yearPublication)
                .checkNews(newstitle);
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Проверка верхнего меню")
    void checkMenuTest() {
        domrfPage.openPage()
                .openItemOfHeaderMenu(itemOfHeaderMenu)
                .checkHeaderMenu(list);

    }

    @Test
    @Tag("Smoke")
    @DisplayName("Проверка наличия ссылок на соц. сети")
    void checkSocialsLinksTest() {
        domrfPage.openPage()
                .checkSocialsLinks();
    }
}

package ru.lemur;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lemur.pages.MainPage;
import ru.lemur.pages.SearchResultsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Features("Проверка строки поиска")
public class FindVideoTest extends TestNgTestBase {

    @BeforeMethod(description = "Престеп: заходим на страницу")
    public void initPageObjects() {
        driver.get(baseUrl);
    }

    @Test(description = "Базовый поиск")
    @Stories("Базовый поиск")
    public void testBaseSearch() {

        String query = "PSY - Gangnam style";
        MainPage mainPage = new MainPage(driver);
        mainPage.search(query);
        mainPage.waitForPageLoaded();

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.waitForPageLoaded();
        searchResultsPage.checkIsFindStringInResult(query);

    }

    @Test(description = "Поиск с опечаткой")
    @Stories("Поиск с опечаткой")
    public void testTypeErrorSearch() {

        String query = "PSY - Ganam style";
        String correctQuery = "PSY - Gangnam style";
        MainPage mainPage = new MainPage(driver);
        mainPage.search(query);
        mainPage.waitForPageLoaded();

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.waitForPageLoaded();

        searchResultsPage.checkIsQueryChanged(correctQuery);

    }

}

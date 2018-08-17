package ru.lemur;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lemur.helpers.Generators;
import ru.lemur.pages.CreateAccountPage;
import ru.lemur.pages.LogInPage;
import ru.lemur.pages.MainPage;
import ru.lemur.pages.SearchResultsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Features("Тесты на регистрацию")
public class RegisterTest extends TestNgTestBase {

    @BeforeMethod(description = "Престеп: заходим на страницу")
    public void initPageObjects() {
        driver.get(baseUrl);
    }

    @Test(description = "Базовый регистрация")
    @Stories("Базовая регистрация")
    public void testBaseSearch() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogInBtn();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.clickCreateAccountBtn();

        String email = Generators.getRandomString(12) + "@gmail.com";
        String pass = Generators.getRandomString(10);

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.fillForm("Имя", "Фамилия", email, pass, pass);
        createAccountPage.clickAccept();
        createAccountPage.checkDataIsRight();
    }

    @Test(description = "Пустные данные при регистрации")
    @Stories("Пустные данные при регистрации")
    public void testTypeErrorSearch() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogInBtn();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.clickCreateAccountBtn();

        String email = Generators.getRandomString(12) + "@gmail.com";
        String pass = Generators.getRandomString(10);

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.clickAccept();
        createAccountPage.checkErrors();
    }

}

package ru.lemur.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Страница с результатами поиска
 */
public class SearchResultsPage extends Page {

    @FindBy(id = "contents")
    private WebElement searchResults;

    @FindBy(id = "corrected")
    private WebElement incorrectString;

    @FindBy(id = "corrected-link")
    private WebElement correctedLink;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        driver.get(driver.getCurrentUrl()); //я не знаю, что не так с ютубом, но при простом переходе на страницу
        //дравер не подтягивает новые значения...
        PageFactory.initElements(driver, this);
    }

    public List<String> getAllVideoNames() {
        List<WebElement> titles = searchResults.findElements(By.xpath(".//h3/a"));
        List<String> stringTitles = new ArrayList<>();
        for (WebElement el : titles) {
            stringTitles.add(el.getAttribute("title"));
        }
        return stringTitles;
    }

    public void checkIsFindStringInResult(String query) {
        List<String> allVideoNames = getAllVideoNames();
        for (String videoName : allVideoNames) {
            if (videoName.toLowerCase().contains(query.toLowerCase()))
                return;
        }
        Assert.fail("Youtube не смог найти подходящих видео");
    }

    public void checkIsQueryChanged(String correctQuery) {
        Assert.assertNotNull(incorrectString, "Сообщение о результате поиска не найдено");
        Assert.assertEquals(correctedLink.getText().toLowerCase(), correctQuery.toLowerCase(),
                "Исправленный запрос не тот, который мы ожидали");

    }
}

package ru.lemur.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Sample page
 */
public class MainPage extends Page {
    @FindBy(name = "search_query")
    private WebElement findTextField;

    @FindBy(id = "search-icon-legacy")
    private WebElement searchBtn;

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get(driver.getCurrentUrl()); //я не знаю, что не так с ютубом, но при простом переходе на страницу
        //дравер не подтягивает новые значения...
        PageFactory.initElements(driver, this);
    }


    public void search(String query){
        findTextField.sendKeys(query);
        searchBtn.click();
    }



}


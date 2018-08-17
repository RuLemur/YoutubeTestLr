package ru.lemur.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница авторизации
 */
public class LogInPage extends Page {

    @FindBy(xpath = "//*[text()='Создать аккаунт']")
    private WebElement createAccountLink;

    public LogInPage(WebDriver driver) {
        super(driver);
        driver.get(driver.getCurrentUrl()); //я не знаю, что не так с ютубом, но при простом переходе на страницу
        //дравер не подтягивает новые значения...
        PageFactory.initElements(driver, this);
    }


    public void clickCreateAccountBtn(){
        createAccountLink.click();
        this.waitForPageLoaded();
    }


}


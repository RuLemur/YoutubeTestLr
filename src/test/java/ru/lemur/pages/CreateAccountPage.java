package ru.lemur.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

/**
 * Страница создания нового аккаунта
 */
public class CreateAccountPage extends Page {

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "Username")
    private WebElement email;

    @FindBy(name = "Passwd")
    private WebElement passwd;

    @FindBy(name = "ConfirmPasswd")
    private WebElement confirmPasswd;

    @FindBy(xpath = "//*[text()='Далее']")
    private WebElement acceptRegister;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        driver.get(driver.getCurrentUrl()); //я не знаю, что не так с ютубом, но при простом переходе на страницу
        //дравер не подтягивает новые значения...
        PageFactory.initElements(driver, this);
    }


    public void fillForm(String firstName, String lastName, String email, String password, String confirmPasswrod) {
        if (firstName != null) {
            this.firstName.sendKeys(firstName);
        }
        if (lastName != null) {
            this.lastName.sendKeys(lastName);
        }
        if (email != null) {
            this.email.sendKeys(email);
        }
        if (password != null) {
            this.passwd.sendKeys(password);
        }
        if (confirmPasswrod != null) {
            this.confirmPasswd.sendKeys(confirmPasswrod);
        }
        this.waitForPageLoaded();
    }

    public void clickAccept() {
        acceptRegister.click();
        this.waitForPageLoaded();
    }

    public void checkDataIsRight() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[text()='Подтвердите адрес электронной почты']"));
        Assert.assertFalse(elements.isEmpty(), "Данные некорректны");
    }

    public void checkErrors() {
        List<WebElement> firstName = driver.findElements(By.xpath("//*[text()='Укажите имя']"));
        Assert.assertFalse(firstName.isEmpty(), "Нету ошибки о вводе имени");
        List<WebElement> lastName = driver.findElements(By.xpath("//*[text()='Укажите фамилию']"));
        Assert.assertFalse(lastName.isEmpty(), "Нету ошибки о вводе фамиллии");
        List<WebElement> email = driver.findElements(By.xpath("//*[text()='Укажите адрес Gmail']"));
        Assert.assertFalse(email.isEmpty(), "Нету ошибки о вводе емейла");
        List<WebElement> pass = driver.findElements(By.xpath("//*[text()='Введите пароль']"));
        Assert.assertFalse(pass.isEmpty(), "Нету ошибки о вводе пароля");
    }

}


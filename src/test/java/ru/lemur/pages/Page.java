package ru.lemur.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

/**
 *  Базовый абстрактный класс страницы
 */
public abstract class Page {

    protected WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    /*
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void waitForPageLoaded() {

        WebDriverWait waiter = new WebDriverWait(driver, 10);
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .toString().equals("complete");
        try {
            Thread.sleep(1000);
            waiter.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}

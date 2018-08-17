package ru.lemur;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

    protected static String baseUrl;
    protected static Capabilities capabilities;

    protected WebDriver driver;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        SuiteConfiguration config = new SuiteConfiguration();
        baseUrl = config.getProperty("site.url");
        capabilities = config.getCapabilities();

        String webDriverPath = "";
        String osName = System.getProperty("os.name").toLowerCase();
        String browserName = capabilities.getBrowserName();
        if (osName.contains("mac")) {
            webDriverPath = config.getProperty("browser.webdriver_mac");
        }
        if (osName.contains("windows")) {
            webDriverPath = config.getProperty("browser.webdriver_win");
        }
        System.setProperty(String.format("webdriver.%s.driver", browserName), webDriverPath);
    }

    @BeforeMethod
    public void initWebDriver() {
        driver = WebDriverPool.DEFAULT.getDriver(capabilities);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}

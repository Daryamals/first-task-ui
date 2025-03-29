package tests;

import helpers.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
@Epic("Базовые тесты")
public class BaseTest {
    protected WebDriver driver;
    @Step("Запуск браузера и открытие страницы")
    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.createDriver();
        driver.manage().window().maximize();
        WebDriverManager.navigateTo(driver);
    }
    @Step("Закрытие браузера")
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
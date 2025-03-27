package pages;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Общий метод для клика по элементу
    protected void click(By locator) {
        WebElement element = driver.findElement(locator);
        WaitHelper.waitForElementToBeClickable(driver, element, 10);
        element.click();
    }

    // Общий метод для ввода текста
    protected void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        WaitHelper.waitForElementVisibility(driver, element, 10);
        element.clear();
        element.sendKeys(text);
    }

    // Получение текста алерта
    public String getAlertText() {
        WaitHelper.waitForAlert(driver, 10);
        return driver.switchTo().alert().getText();
    }

    // Подтверждение алерта
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // Переход на указанную страницу
    public void navigateTo(String url) {
        driver.get(url);
    }
} 

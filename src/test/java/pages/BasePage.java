package pages;

import helpers.WaitHelper;
import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on element {locator}")
    protected void click(By locator) {
        WebElement element = driver.findElement(locator);
        WaitHelper.waitForElementToBeClickable(driver, element, 10);
        element.click();
    }
    @Step("Enter text '{text}' into element {locator}")
    protected void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        WaitHelper.waitForElementVisibility(driver, element, 10);
        element.clear();
        element.sendKeys(text);
    }

    public String getAlertText() {
        WaitHelper.waitForAlert(driver, 10);
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }
} 
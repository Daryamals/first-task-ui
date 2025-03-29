package helpers;

import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    @Step("Ожидание появления алерта в течение {timeoutInSeconds} секунд")
    public static Alert waitForAlert(WebDriver driver, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    @Step("Ожидание видимости элемента {element} в течение {timeoutInSeconds} секунд")
    public static void waitForElementVisibility(
        WebDriver driver, WebElement element, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Step("Ожидание кликабельности элемента {element} в течение {timeoutInSeconds} секунд")
    public static void waitForElementToBeClickable(
        WebDriver driver, WebElement element, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
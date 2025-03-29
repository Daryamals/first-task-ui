package pages;

import helpers.WaitHelper;
import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomersPage extends BasePage {
    private By searchField = By.xpath("//input[@placeholder='Search Customer']");
    private By customerRows = By.xpath("//table//tr[contains(@class, 'ng-scope')]");
    private By customerNameColumn = By.xpath(".//td[1]");
    private By deleteButtonColumn = By.xpath(".//td/button[contains(text(), 'Delete')]");
    private By sortByFirstNameButton = By.xpath("//a[contains(text(), 'First Name')]");

    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    @Step("Поиск клиента с именем: {customerName}")
    public void searchCustomer(String customerName) {
        sendKeys(searchField, customerName);
    }

    @Step("Получение списка всех клиентов")
    public List<String> getCustomerNames() {
        return driver.findElements(customerRows)
            .stream()
            .map(row -> row.findElement(customerNameColumn).getText())
            .collect(Collectors.toList());
    }

    @Step("Сортировка клиентов по имени")
    public void sortByFirstName() {
        driver.findElement(sortByFirstNameButton).click();
        WaitHelper.waitForElementVisibility(driver, driver.findElement(customerRows), 10);
    }

    @Step("Удаление клиента по имени")
    public void deleteCustomer(String customerName) {
        driver.findElements(customerRows)
            .stream()
            .filter(row -> row.findElement(customerNameColumn).getText().equals(customerName))
            .findFirst()
            .ifPresent(row -> {
                WebElement deleteButton = row.findElement(deleteButtonColumn);
                WaitHelper.waitForElementToBeClickable(driver, deleteButton, 10);
                deleteButton.click();
            });
    }
}

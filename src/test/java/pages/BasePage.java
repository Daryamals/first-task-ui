package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerPage extends BasePage {
    private By addCustomerButton = By.xpath("//button[contains(text(), 'Add Customer')]");

    private By customersButton = By.xpath("//button[contains(text(), 'Customers')]");

    public ManagerPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход на страницу добавления клиента")

    public void clickAddCustomer() {
        click(addCustomerButton);
    }

    @Step("Переход на страницу клиентов")

    public void clickCustomers() {
        click(customersButton);
    }
}
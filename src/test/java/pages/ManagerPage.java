package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerPage extends BasePage {

    private By addCustomerButton = By.xpath("//button[contains(text(), 'Add Customer')]");
    private By customersButton = By.xpath("//button[contains(text(), 'Customers')]");

    public ManagerPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddCustomer() {
        click(addCustomerButton);
    }

    public void clickCustomers() {
        click(customersButton);
    }
}
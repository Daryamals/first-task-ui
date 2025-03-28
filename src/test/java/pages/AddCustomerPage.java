package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class AddCustomerPage extends BasePage {
	private By firstNameField = By.xpath("//input[@placeholder='First Name']");
	private By lastNameField = By.xpath("//input[@placeholder='Last Name']");
	private By postCodeField = By.xpath("//input[@placeholder='Post Code']");
	private By addCustomerButton = By.xpath("//button[@type='submit' and contains(text(), 'Add Customer')]");

	public AddCustomerPage(WebDriver driver) {
		super(driver);
	}

	@Step("Добавление клиента: {firstName} {lastName} ({postCode})")
	public void addCustomer(String firstName, String lastName, String postCode) {
		sendKeys(firstNameField, firstName);
		sendKeys(lastNameField, lastName);
		sendKeys(postCodeField, postCode);
		click(addCustomerButton);
	}
}
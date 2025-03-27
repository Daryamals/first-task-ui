package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomersPage extends BasePage {

	private By searchField = By.xpath("//input[@placeholder='Search Customer']");
	private By deleteButton = By.xpath("//button[contains(text(), 'Delete')]");

	public CustomersPage(WebDriver driver) {
		super(driver);
	}

	public void searchCustomer(String customerName) {
		sendKeys(searchField, customerName);
	}

	public void deleteCustomer() {
		click(deleteButton);
	}

	public List<String> getCustomerNames() {
		return driver.findElements(By.xpath("//table//tr/td[1]")).stream().map(WebElement::getText)
				.collect(Collectors.toList());
	}

	public void sortByFirstName() {
		driver.findElement(By.xpath("//a[contains(text(), 'First Name')]")).click();
	}

	public void deleteCustomerByName(String name) {
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));

		for (WebElement row : rows) {
			WebElement nameCell = row.findElement(By.xpath("./td[1]"));
			if (nameCell.getText().equals(name)) {
				row.findElement(By.xpath(".//button[text()='Delete']")).click();
				break;
			}
		}
	}

}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.CustomersPage;
import pages.ManagerPage;

import java.util.List;

@Epic("Управление клиентами")
@Feature("Сортировка клиентов")
public class SortCustomersTest extends BaseTest {

	@Test
	@Story("Сортировка по имени")
	@Description("Проверяем корректность сортировки списка клиентов по имени в обратном порядке")

	public void testSortCustomersByFirstName() {
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
		
		ManagerPage managerPage = new ManagerPage(driver);
		managerPage.clickCustomers();
		CustomersPage customersPage = new CustomersPage(driver);
		
		List<String> namesBeforeSort = customersPage.getCustomerNames();
		customersPage.sortByFirstName();
		
		List<String> namesAfterSort = customersPage.getCustomerNames();
		
		Allure.step("Имена после сортировки: " + namesAfterSort);

		List<String> expectedSortedNames = namesBeforeSort.stream().sorted((name1, name2) -> name2.compareTo(name1))
				.toList();

		Assert.assertEquals(namesAfterSort, expectedSortedNames,
				"Список клиентов не отсортирован по имени в обратном порядке.");
	}
}
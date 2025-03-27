package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.ManagerPage;

import java.util.List;

public class SortCustomersTest extends BaseTest {

    @Test
    public void testSortCustomersByFirstName() {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.clickCustomers();

        CustomersPage customersPage = new CustomersPage(driver);
        
        List<String> namesBeforeSort = customersPage.getCustomerNames();
        
        customersPage.sortByFirstName();
        
        List<String> namesAfterSort = customersPage.getCustomerNames();
        
        List<String> expectedSortedNames = namesBeforeSort.stream().sorted().toList();
        Assert.assertEquals(namesAfterSort, expectedSortedNames, "Список клиентов не отсортирован по имени.");
    }
}

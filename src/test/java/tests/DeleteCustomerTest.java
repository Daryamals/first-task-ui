package tests;

import data.DeleteCustomerData;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.ManagerPage;

@Test
@Epic("Управление клиентами")
@Feature("Удаление клиента")
public class DeleteCustomerTest extends BaseTest {
    @Test
    @Story("Удаление клиента по средней длине имени")
    @Description("Удаляем клиента, имя которого ближе всего к средней длине имён")
    public void testDeleteCustomer() {
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.clickCustomers();

        CustomersPage customersPage = new CustomersPage(driver);

        List<String> customerNames = customersPage.getCustomerNames();
        double averageNameLength = DeleteCustomerData.getAverageNameLength(customerNames);
        String customerToDelete =
            DeleteCustomerData.getCustomerToDelete(customerNames, averageNameLength);

        Allure.step("Средняя длина имен: " + averageNameLength);
        Allure.step("Удаляем клиента с именем: " + customerToDelete);

        customersPage.deleteCustomer(customerToDelete);

        List<String> updatedCustomerNames = customersPage.getCustomerNames();
        Assert.assertFalse(
            updatedCustomerNames.contains(customerToDelete), "Клиент не был удален.");
    }
}
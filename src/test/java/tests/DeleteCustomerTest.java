package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.ManagerPage;
import data.DeleteCustomerData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import java.util.List;
@Epic("Управление клиентами")
@Feature("Удаление клиента")
public class DeleteCustomerTest extends BaseTest {

    @Test
    @Story("Удаление клиента по средней длине имени")
    @Description("Удаляем клиента, имя которого ближе всего к средней длине имён")
    public void testDeleteCustomerByAverageNameLength() {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.clickCustomers();

        CustomersPage customersPage = new CustomersPage(driver);

        List<String> customerNames = DeleteCustomerData.CUSTOMER_NAMES;

        if (customerNames.isEmpty()) {
            Assert.fail("Нет клиентов для удаления.");
            return;
        }

        double averageLength = DeleteCustomerData.getAverageNameLength(customerNames);

        String nameToDelete = DeleteCustomerData.getCustomerToDelete(customerNames, averageLength);

        if (nameToDelete == null) {
            Assert.fail("Не найдено имя для удаления.");
            return;
        }

        customersPage.deleteCustomerByName(nameToDelete);

        List<String> updatedNames = customersPage.getCustomerNames();
        Assert.assertFalse(updatedNames.contains(nameToDelete), "Клиент не был удален.");
    }
}
package tests;

import static data.AddCustomerData.FIRST_NAME;
import static data.AddCustomerData.LAST_NAME;
import static data.AddCustomerData.POST_CODE;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pages.AddCustomerPage;
import pages.ManagerPage;

@Epic("Управление клиентами")
@Feature("Добавление клиента")
public class AddCustomerTest extends BaseTest {

    @Test
    @Story("Добавление нового клиента")
    @Description("Этот тест проверяет добавление нового клиента и отображение сообщения об успехе.")
  
    public void testAddCustomer() {
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.clickAddCustomer();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addCustomer(FIRST_NAME, LAST_NAME, POST_CODE);

        Assert.assertTrue(addCustomerPage.getAlertText().contains("Customer added successfully with customer id"));
        addCustomerPage.acceptAlert();
    }
}
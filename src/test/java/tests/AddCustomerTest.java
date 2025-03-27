package tests;

import static data.AddCustomerData.FIRST_NAME;
import static data.AddCustomerData.LAST_NAME;
import static data.AddCustomerData.POST_CODE;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddCustomerPage;
import pages.ManagerPage;

public class AddCustomerTest extends BaseTest {

    @Test
    public void testAddCustomer() {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.clickAddCustomer();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.addCustomer(FIRST_NAME, LAST_NAME, POST_CODE);

        Assert.assertTrue(addCustomerPage.getAlertText().contains("Customer added successfully with customer id"));
        addCustomerPage.acceptAlert();
    }
}

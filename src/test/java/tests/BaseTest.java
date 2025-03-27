package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import helpers.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.createDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

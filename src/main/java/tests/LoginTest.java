package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        // Navigate to the login page of local OpenCart
        driver.get("https://www.amazon.in/?ref_=nav_ya_signin&");

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Perform login with valid credentials
        loginPage.login("9700928278", "Ramayya234@");
    }
}


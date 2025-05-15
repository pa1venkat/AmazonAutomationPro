package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.SearchPage;
import utilities.BaseTest;

public class CheckoutTest extends BaseTest {
    @Test
    public void completeCheckoutProcess() throws Exception {
    	driver.get("https://www.amazon.in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchProduct("iphone 16");
        searchPage.BuyNow();
        CartPage cartPage = new CartPage(driver);
        cartPage.viewCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckout();
    }
}

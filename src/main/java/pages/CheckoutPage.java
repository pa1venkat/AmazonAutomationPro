package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) { this.driver = driver; }
    public void proceedToCheckout() {
        driver.findElement(By.linkText("Checkout")).click();
    }
}

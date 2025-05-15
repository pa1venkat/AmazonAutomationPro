package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) { this.driver = driver; }
    public void viewCart() {
    	driver.findElement(By.xpath("//i[@class='fa-solid fa-cart-shopping']")).click();
    }
}

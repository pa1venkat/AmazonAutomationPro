package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class saucedemo {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void loginAndAddItemsToCart() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        // Zoom out to 67%
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='67%'");

        // Add all items to cart
        driver.findElement(By.cssSelector(".inventory_item button")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void checkoutAndPlaceOrder() throws InterruptedException {
        // Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        // Checkout
        driver.findElement(By.id("checkout")).click();

        // Fill in info
        driver.findElement(By.id("first-name")).sendKeys("Pavan");
        driver.findElement(By.id("last-name")).sendKeys("Venkat");
        driver.findElement(By.id("postal-code")).sendKeys("500060");
        Thread.sleep(2000);

        // Continue & finish
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);

        // Confirmation check
        WebElement confirmation = driver.findElement(By.className("complete-header"));
        if (confirmation.getText().equals("Thank you for your order!")) {
            System.out.println("✅ Order completed successfully!");
        } else {
            System.out.println("❌ Order not completed.");
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

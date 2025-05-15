//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//
//public class SearchPage {
//    WebDriver driver;
//
//    public SearchPage(WebDriver driver) throws Exception {
//        this.driver = driver;
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        // Zoom out to 80%
//        js.executeScript("document.body.style.zoom='80%'");
//        
//        if (driver.getPageSource().contains("captcha")) {
//            System.out.println("CAPTCHA detected. Waiting for manual input...");
//            Thread.sleep(30000); // wait 30 seconds for manual solving
//        }
//
//    }
//
//    // Method to search for any product by name
//    public void searchProduct(String productName) {
//        driver.findElement(By.id("twotabsearchtextbox")).clear();
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName);
//        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
//
//        driver.findElement(By.xpath("//img[contains(@class, 's-image')]")).click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;js.executeScript("window.scrollBy(0,250)");
//
//    }
//    public void addToCart() {
//
//}}
//
//
//
//

//----------------------------------------------------------------------------------------//

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;
    JavascriptExecutor js;

    // Constructor
    public SearchPage(WebDriver driver) throws Exception {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;

        // Zoom out to 80% only once
        js.executeScript("document.body.style.zoom='80%'");

        // Check for CAPTCHA text in page source
        if (driver.getPageSource().toLowerCase().contains("captcha")) {
            System.out.println("CAPTCHA detected. Please solve it manually.");
            Thread.sleep(30000); // Wait 30 seconds for manual solving
        }
    }

    // Search for any product by name
    public void searchProduct(String productName) {
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName);
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Click the first product image from search results
        driver.findElement(By.xpath("//img[contains(@class, 's-image')]")).click();

        // Scroll down by 250px
        js.executeScript("window.scrollBy(0, 250)");
    }

    // Add to cart functionality placeholder
    public void BuyNow() {
        driver.findElement(By.id("buy-now-button")).click();
        
    }
}


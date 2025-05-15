package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) { this.driver = driver; }
    public void login(String email, String password) {
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        driver.findElement(By.id("ap_email_login")).sendKeys(email);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
    }
}

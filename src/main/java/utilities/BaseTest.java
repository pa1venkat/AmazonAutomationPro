package utilities;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public WebDriver driver;
    public ExtentReports extent;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       
        extent = ExtentManager.createInstance();
    }
    @AfterMethod
    public void tearDown() {
//        driver.quit();
        extent.flush();
    }
}

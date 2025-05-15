package tests;

import org.testng.annotations.Test;
import pages.SearchPage;
import utilities.BaseTest;

public class SearchTest extends BaseTest {
    @Test
    public void searchProductTest() throws Exception {
        driver.get("https://www.amazon.in/");
        
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchProduct("iqoo Neo 10R");
    }
}

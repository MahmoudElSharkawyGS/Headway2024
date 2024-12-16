package google.tests;

import google.pages.HomePage;
import google.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestsSetup {
    WebDriver driver;
    protected HomePage homePage;
    protected SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

package google.tests;

import google.pages.HomePage;
import google.pages.SearchResultsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DriverFactory;
import utilities.JsonFileManager;
import utilities.PropertiesReader;

public class googleTestsFluentDesign {
    private WebDriver driver;
    private JsonFileManager testData;

    @Test(description = "Google Search 1")
    @Description("Google Search 1 Allure description")
    @Severity(SeverityLevel.CRITICAL)
    public void googleSearchFluentDesign1() {
        new HomePage(driver)
                .navigate()
                .assertGoogleHomePage()
                .googleSearch(testData.getTestData("searchQueries.searchQuery"));
        new SearchResultsPage(driver)
                .assertOnFirstSearchResultsText(testData.getTestData("firstSearchResultsExpected"))
                .clickOnFirstSearchResult();
    }

    @Test(description = "Google Search 2")
    @Description("Google Search 2 Allure description")
    @Severity(SeverityLevel.BLOCKER)
    public void googleSearchFluentDesign2() {
        new HomePage(driver)
                .navigate()
                .assertGoogleHomePage()
                .googleSearch(testData.getTestData("searchQueries.SearchQuery2"))
                .assertOnFirstSearchResultsText(testData.getTestData("firstSearchResultsExpected2"))
                .clickOnFirstSearchResult();
    }


    /////////// Configurations \\\\\\\\\\\\\
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initiateDriver(System.getProperty("browserName"), true);
        testData = new JsonFileManager("src/test/resources/TestDataJsonFiles/GoogleTestsJsonFile.json");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @BeforeSuite
    public void beforeSuite() {
        PropertiesReader.loadProperties();
    }
}

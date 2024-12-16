package google.tests;

import google.pages.HomePage;
import google.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ExcelFileManager;

import java.io.File;

public class googleTestsFluentDesignExcel {
    private WebDriver driver;
    private ExcelFileManager testData;

    @Test
    public void googleSearchFluentDesign1() {
        new HomePage(driver)
                .navigate()
                .assertGoogleHomePage()
                .googleSearch(testData.getCellData("SearchQuery"));
        new SearchResultsPage(driver)
                .assertOnFirstSearchResultsText(testData.getCellData("ExpectedResults", 3))
                .clickOnFirstSearchResult();
    }



    /////////// Configurations \\\\\\\\\\\\\
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        testData = new ExcelFileManager("src/test/resources/TestDataExcelFiles/GoogleTestsExcelTestData.xlsx");
        testData.switchToSheet("google");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

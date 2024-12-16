package google.tests;

import google.pages.HomePage;
import google.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class googleTests extends TestsSetup {

    @Test
    public void googleSearch1() {
        HomePage homePage = new HomePage(driver);
        homePage.navigate();
        Assert.assertEquals(homePage.getTitleText(), "Google");
        Assert.assertTrue(homePage.getUrlText().contains("google"));
        Assert.assertTrue(homePage.getSearchFieldElement().isDisplayed());
        homePage.googleSearch("Headway 2024");
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        Assert.assertEquals(searchResultsPage.getFirstSearchResultsText(), "Headway Intern 2024 - Integration - JB5091189 | Cairo ...");
        searchResultsPage.clickOnFirstSearchResult();
    }

    @Test
    public void googleSearch2() {
        homePage.navigate();
        Assert.assertEquals(homePage.getTitleText(), "Google");
        Assert.assertTrue(homePage.getUrlText().contains("google"));
        Assert.assertTrue(homePage.getSearchFieldElement().isDisplayed());
        homePage.googleSearch("Headway 2024");
        Assert.assertEquals(searchResultsPage.getFirstSearchResultsText(), "Headway Intern 2024 - Integration - JB5091189 | Cairo ...");
        searchResultsPage.clickOnFirstSearchResult();
    }

    @Test
    public void googleSearch3() {
        homePage.navigate();
        homePage.assertGoogleHomePage();
        homePage.googleSearch("Headway 2024");
        searchResultsPage.assertOnFirstSearchResultsText("Headway Intern 2024 - Integration - JB5091189 | Cairo ...");
        searchResultsPage.clickOnFirstSearchResult();
    }

}

package google.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.BrowserActions;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private String url = "https://www.google.com/ncr";

    // Locators
    private By searchField_textArea = By.name("q");

    /////////////////// Actions \\\\\\\\\\\\\\\\\
    public HomePage navigate() {
//        driver.get(url);
        BrowserActions.navigate(driver, url);
        return this;
    }

    @Step("Google Search with {searchData}")
    public SearchResultsPage googleSearch(String searchData) {
        driver.findElement(searchField_textArea).sendKeys(searchData);
        driver.findElement(searchField_textArea).sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    public String getTitleText() {
        return driver.getTitle();
    }

    public String getUrlText() {
        return driver.getCurrentUrl();
    }

    public WebElement getSearchFieldElement() {
        return driver.findElement(searchField_textArea);
    }

    /////////////////// Validations \\\\\\\\\\\\\\\
    @Step("Assert on Google Home Page")
    public HomePage assertGoogleHomePage() {
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        Assert.assertTrue(driver.findElement(searchField_textArea).isDisplayed());
        return this;
    }
}

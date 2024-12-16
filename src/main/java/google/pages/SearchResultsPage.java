package google.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ElementActions;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By firstSearchResults_h3 = By.xpath("(//h3)[1]");

    /////////// Actions \\\\\\\\\\\\
    public String getFirstSearchResultsText() {
        return driver.findElement(firstSearchResults_h3).getText();
    }

    @Step("Click on First Search Result")
    public void clickOnFirstSearchResult() {
//        driver.findElement(firstSearchResults_h3).click();
        ElementActions.click(driver, firstSearchResults_h3);
    }

    ///////////////// Validations \\\\\\\\\\\\
    @Step("Assert on First Search Result Text, Should be {expectedText}")
    public SearchResultsPage assertOnFirstSearchResultsText(String expectedText) {
        Assert.assertEquals(driver.findElement(firstSearchResults_h3).getText(), expectedText);
        return this;
    }
}

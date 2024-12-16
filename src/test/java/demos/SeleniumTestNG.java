package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTestNG {
    WebDriver driver;

    // Locators
    private By searchField = By.name("q");
    private By firstSearchResults = By.xpath("(//h3)[1]");

    @Test
    public void googleSearch1() {
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        Assert.assertTrue(driver.findElement(By.name("q")).isDisplayed());
        driver.findElement(By.name("q")).sendKeys("Giza Systems");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("(//h3)[1]")).getText().contains("sGiza Systems"), "Expected [sGiza Systems] to be contained in the following: " + driver.findElement(By.xpath("(//h3)[1]")).getText());
    }

    @Test
    public void googleSearch2() {
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        Assert.assertTrue(driver.findElement(searchField).isDisplayed());
        googleSearch("Selenium");
        Assert.assertEquals(getFirstSearchResultsText(), "Selenium");
    }

    @Test
    public void googleSearch3() {
        assertGoogleHomePage();
        googleSearch("Headway 2024");
        assertOnFirstSearchResultsText("Headway Intern 2024 - Integration - JB5091189 | Cairo ...");
    }

    ///////////// Configurations \\\\\\\\\\\\\\\\

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.google.com/ncr");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    /////////////////////// Action Methods
    private void googleSearch(String searchData) {
        driver.findElement(searchField).sendKeys(searchData);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
    }

    private String getFirstSearchResultsText() {
        return driver.findElement(firstSearchResults).getText();
    }

    //////////////// Assertions

    private void assertOnFirstSearchResultsText(String expectedText) {
        Assert.assertEquals(driver.findElement(firstSearchResults).getText(), expectedText);
    }

    private void assertGoogleHomePage() {
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        Assert.assertTrue(driver.findElement(searchField).isDisplayed());
    }


}

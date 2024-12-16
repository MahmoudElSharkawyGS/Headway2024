package headway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWaits {
    WebDriver driver;

    @Test
    public void waitImplicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#finish")).getText(), "Hello World!");
    }

    @Test
    public void waitExplicit() {
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish")));

        Assert.assertEquals(driver.findElement(By.cssSelector("#finish")).getText(), "Hello World!");
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @AfterMethod
    public void teamDown() {
        driver.quit();
    }
}

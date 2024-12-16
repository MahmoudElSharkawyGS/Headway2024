package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {
    private static WebDriver driver;
    private static Wait<WebDriver> wait;
    private static int defaultWaitTime = 10;

    @Step("Click on Element: {elementLocator}")
    public static void click(WebDriver driver, By elementLocator) {
        elementWaitingStrategy(driver, elementLocator);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        System.out.println("Clicking on element: " + driver.findElement(elementLocator).getAccessibleName() + "and it's locator is: " + elementLocator);
        driver.findElement(elementLocator).click();
    }


    private static void elementWaitingStrategy(WebDriver driver, By elementLocator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
}

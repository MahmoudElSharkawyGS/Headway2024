package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    static WebDriver driver;

    public static WebDriver initiateDriver(String browserName, boolean maximize) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.out.println("initializing Chrome Browser on OS: " + System.getProperty("os.name") + " and it's version is: " + System.getProperty("os.version"));
            driver = new ChromeDriver();
            System.out.println("Successfully initialized the Chrome Browser");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(System.getProperty("defaultWaitTime"))));
        if (maximize) {
            driver.manage().window().maximize();
            System.out.println("Window is maximized. And the new window size is now: " + driver.manage().window().getSize());
        }
        return driver;
    }
}

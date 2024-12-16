package headway;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FistSeleniumDemo {

   public static void main(String[] args) {
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
//      driver.navigate().to("https://www.google.com/");
      driver.get("https://www.google.com/ncr");
//      driver.findElement(By.id("APjFqb")).sendKeys("Headway 2024");
//      driver.findElement(By.name("q")).sendKeys("Headway 2024");
//      driver.findElement(By.className("gLFyf")).sendKeys("Headway 2024");
//      driver.findElement(By.tagName("textarea")).sendKeys("Headway 2024");
//      driver.findElement(By.linkText("Gmail")).click();
//      driver.findElement(By.partialLinkText("Gma")).click();
//      driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea")).sendKeys("Headway 2024");
//      driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div.SDkEP > div.a4bIc > textarea")).sendKeys("Headway 2024");
//      driver.findElement(By.xpath("//textarea[@aria-label='بحث' or @aria-label='Search']")).sendKeys("Headway 2024");
      driver.findElement(By.cssSelector("textarea[title='Search'],[title='بحث']")).sendKeys("Headway 2024", Keys.ENTER);
//      driver.findElement(By.cssSelector("textarea[title='Search'],[title='بحث']")).sendKeys(Keys.ENTER);
      System.out.println(driver.findElement(By.xpath("(//h3)[1]")).getText());
   }

}

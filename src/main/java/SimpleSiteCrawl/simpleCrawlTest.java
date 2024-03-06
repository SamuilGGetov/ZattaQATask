package SimpleSiteCrawl;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class simpleCrawlTest {
    WebDriver driver;
   @Test public void crawlerTesting () {
       String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + "_results.txt";

       try (FileWriter writer = new FileWriter(fileName)) {
           driver.get("https://www.amazon.com");

           //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-hamburger-menu")));

           // Open "Shop By Department" menu
           WebElement menu = driver.findElement(By.id("nav-hamburger-menu"));
           menu.click();

           // Wait for the menu to open and then get all links

           //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hmenu-visible")));
           List<WebElement> links = driver.findElements(By.cssSelector(".hmenu-visible .hmenu-item"));

           for (WebElement link : links) {
               String url = link.getAttribute("href");
               String text = link.getText();
               if (url != null) {
                   driver.get(url);
                   String title = driver.getTitle();
                   String status = "OK";
                   if (title.contains("404") || title.toLowerCase().contains("page not found")) {
                       status = "Dead link";
                   }
                   writer.write(url + ", " + title + ", " + status + "\n");
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           //   driver.quit();
       }

   }
}

package Pages;

import ElementsLocatorsAndStrings.elementsLocators;
import ElementsLocatorsAndStrings.webStrings;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadTheWebsite {
    static Duration timeout = Duration.ofSeconds(20);


    public static void websiteLoad(WebDriver driver) {

        new webStrings();
        new elementsLocators();
        driver.get(webStrings.baseURL);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(webStrings.tryDifferentImageLink);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementsLocators.amazonLogo));
    }
}

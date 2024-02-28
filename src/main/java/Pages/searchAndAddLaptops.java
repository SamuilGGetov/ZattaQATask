package Pages;

import ElementsLocatorsAndStrings.elementsLocators;
import ElementsLocatorsAndStrings.webStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class searchAndAddLaptops {

    WebDriver driver;
    static Duration timeout = java.time.Duration.ofSeconds(3);


    public static void searchForLaptopKeyWord (WebDriver driver) {
    new elementsLocators();
    new webStrings();
        WebElement searchBox = driver.findElement(elementsLocators.searchBoxField);
        searchBox.sendKeys(webStrings.searchedItem);
        searchBox.submit();
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementsLocators.searchResultsField));
    }


    }



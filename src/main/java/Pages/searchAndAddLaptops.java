package Pages;

import ElementsLocatorsAndStrings.elementsLocators;
import ElementsLocatorsAndStrings.webStrings;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class searchAndAddLaptops {

    WebDriver driver;
    static Duration timeout = java.time.Duration.ofSeconds(3);


    public static void clickOnSearchBox(WebDriver driver) {
    new elementsLocators();
    new webStrings();
        driver.findElement(elementsLocators.searchBoxField).click();

    }
    public static void searchForLaptops(WebDriver driver) {
        new elementsLocators();
        new webStrings();
        driver.findElement(elementsLocators.searchBoxField).sendKeys(webStrings.searchedItem);
        driver.findElement(elementsLocators.searchBoxField).submit();
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementsLocators.foundItems));
    }
    public static void addRequiredItemsIntoTheCart (WebDriver driver) {
        new elementsLocators();
        new webStrings();
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        int resultsSize = driver.findElements(elementsLocators.foundItems).size();
        for (int i = 0; i < resultsSize; i++) {
            List<WebElement> searchResults = driver.findElements(elementsLocators.foundItems);
            WebElement result = searchResults.get(i);
            result.click();
            try {
                WebElement discountElement = wait.until(ExpectedConditions.presenceOfElementLocated(elementsLocators.previousPrice));
                boolean isDiscounted = !discountElement.getText().isEmpty();

                if (isDiscounted) {
                    System.out.println("This item is discounted.");
                } else {
                    System.out.println("Item added to the cart.");
                    try {
                        searchAndAddLaptops.checkItemInStock(driver);
                    } catch (Exception e) {
                        searchAndAddLaptops.checkLimitedQuantityInStock(driver);
                    }
                    driver.findElement(elementsLocators.addToCartButton).click();
                    driver.navigate().back();
                }
            } catch (TimeoutException e) {
                System.out.println("No discount found for this item.");
            }
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementsLocators.mainSearchList));
        }
    }
    public static void checkItemInStock (WebDriver driver) {
        new elementsLocators();
        new webStrings();
        String InStock= driver.findElement(elementsLocators.inStock).getText();
        String expectedText= "In Stock";
        Assert.assertEquals(InStock,expectedText);
    }
    public static void checkLimitedQuantityInStock (WebDriver driver) {
        new elementsLocators();
        new webStrings();
        String text= driver.findElement(elementsLocators.limitedQuantityInStock).getText();
        String expectedText = "left in stock";
        assert text.contains(expectedText) : "Text assertion failed";
    }


    }



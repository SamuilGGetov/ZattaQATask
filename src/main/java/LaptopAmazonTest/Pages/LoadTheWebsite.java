package LaptopAmazonTest.Pages;

import LaptopAmazonTest.ElementsLocatorsAndStrings.elementsLocators;
import LaptopAmazonTest.ElementsLocatorsAndStrings.webStrings;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadTheWebsite {
    static Duration timeout = Duration.ofSeconds(20); // the duration is 20 seconds, giving a time for manually enter
    // the characters in the "Type characters" field. This is necessary, because I won't violate the policies of
    // the company by performing tests on a production build.


    public static void websiteLoad(WebDriver driver) {

        new webStrings();
        new elementsLocators();
        driver.get(webStrings.baseURL);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(webStrings.tryDifferentImageLink);

        //JavascriptExecutor is used for clicking on the "Try different image" link and this action managed to proceed
        // further into the amazon.com website (avoiding BOT detection) and to continue with the next test steps and test cases.
        // NB: WORKS ONLY ON MY COMPUTER, I'll provide a screen recording of the execution of the tests.


        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementsLocators.amazonLogo));
    }
}

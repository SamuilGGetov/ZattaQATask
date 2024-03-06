package Pages;

import ElementsLocatorsAndStrings.elementsLocators;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class draftTest {


    static Duration timeout = Duration.ofSeconds(10);

    WebDriver driver = new ChromeDriver();

    private

    @BeforeClass void setUp() {
        new LoadTheWebsite();
        new searchAndAddLaptops();
        new elementsLocators();

    }

    @Test(priority = 1)
    public void loadTheWebSite() {

        LoadTheWebsite.websiteLoad(driver);
    }
    @Test(priority = 2)
    public void searchForLaptops() {
        searchAndAddLaptops.clickOnSearchBox(driver);
        searchAndAddLaptops.searchForLaptops(driver);
    }

    @Test(priority = 3)
    public void addNonDiscountedLaptops() {
      searchAndAddLaptops.addRequiredItemsIntoTheCart(driver);
    }
//
//    @AfterClass
//    public void quitDriver() {
//        driver.quit();
//    }
}



package LaptopAmazonTask.Tests;

import LaptopAmazonTask.ElementsLocatorsAndStrings.elementsLocators;
import LaptopAmazonTask.Pages.LoadTheWebsite;
import LaptopAmazonTask.Pages.searchAndAddLaptops;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LaptopTests {


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

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}



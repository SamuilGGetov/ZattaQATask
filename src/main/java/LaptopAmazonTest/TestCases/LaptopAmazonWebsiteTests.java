package LaptopAmazonTest.TestCases;

import LaptopAmazonTest.ElementsLocatorsAndStrings.elementsLocators;
import LaptopAmazonTest.Pages.LoadTheWebsite;
import LaptopAmazonTest.Pages.searchAndAddLaptops;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static LaptopAmazonTest.Pages.searchAndAddLaptops.addRequiredItemsIntoTheCart;


public class LaptopAmazonWebsiteTests {



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
        addRequiredItemsIntoTheCart(driver);
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}



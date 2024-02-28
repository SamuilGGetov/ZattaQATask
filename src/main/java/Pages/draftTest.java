package Pages;

import ElementsLocatorsAndStrings.elementsLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class draftTest {


    static Duration timeout = Duration.ofSeconds(3);
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
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

        searchAndAddLaptops.searchForLaptopKeyWord(driver);
    }

}

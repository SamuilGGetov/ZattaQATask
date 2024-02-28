package ElementsLocatorsAndStrings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class elementsLocators {

    WebDriver driver;

    static By amazonLogo = By.id("nav-logo-sprites");
    static By searchBoxField = By.id("twotabsearchtextbox");
    static By searchResultsField = By.cssSelector(".s-search-results");
    static By items = By.cssSelector(".s-search-results");
    static By inStock = By.xpath(".//*[contains(text(), 'In Stock')]");
    static By addToCartButton = By.id("add-to-cart-button");
    static By confirmAddToCart = By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS");
    static By backToResultsLink = By.id("breadcrumb-back-link");
    static By previousPrice = By.cssSelector(".a-price a-text-price");


}

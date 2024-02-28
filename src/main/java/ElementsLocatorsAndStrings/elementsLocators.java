package ElementsLocatorsAndStrings;

import org.openqa.selenium.By;


public class elementsLocators {


    public static By amazonLogo = By.id("nav-logo-sprites");
    public static By searchBoxField = By.id("twotabsearchtextbox");
    public static By searchResultsField = By.cssSelector(".s-search-results");
    public static By items = By.cssSelector(".s-search-results");
    public static By inStock = By.xpath(".//*[contains(text(), 'In Stock')]");
    public static By addToCartButton = By.id("add-to-cart-button");
    public static By confirmAddToCart = By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS");
    public static By backToResultsLink = By.id("breadcrumb-back-link");
    public static By previousPrice = By.cssSelector("a-section aok-inline-block");


}

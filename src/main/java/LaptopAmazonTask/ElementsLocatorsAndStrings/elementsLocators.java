package LaptopAmazonTask.ElementsLocatorsAndStrings;

import org.openqa.selenium.By;


public class elementsLocators {


    public static By amazonLogo = By.id("nav-logo-sprites");
    public static By searchBoxField = By.id("twotabsearchtextbox");
   // public static By foundItems = By.cssSelector("a-size-medium a-color-base a-text-normal");
   public static By foundItems = By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']");
    public static By items = By.cssSelector(".s-search-results");
    public static By inStock = By.xpath("//span[@class='a-size-medium a-color-success']");
    public static By limitedQuantityInStock = By.xpath("//*[contains(text(), 'left in stock')]");
  //  public static By addToCartButton = By.xpath("//a[@title='Add to Shopping Cart']");
    public static By addToCartButton = By.cssSelector("input[title='Add to Shopping Cart']");
    public static By backToResultsLink = By.id("breadcrumb-back-link");
    public static By cartButton = By.id("nav-cart-count-container");
    public static By cartButtonItemCount = By.id("nav-cart-count");

    public static By previousPrice = By.xpath("//div[@class='a-section a-spacing-small aok-align-center']");
   // public static By enterDetailedItemInfo = By.cssSelector(".a-section aok-relative s-image-fixed-height"); // unique image locator only for the displayed laptops.
    public static By currentPrice = By.cssSelector(".a-price-whole"); // unique image locator only for the displayed laptops.
    public static By mainSearchList = By.xpath("//span[@data-component-type=\"s-search-results\"]"); // unique image locator only for the displayed laptops.


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator (first prdct)
    private By firstAddToCartButton = By.cssSelector(".btn_inventory");

    // Cart ikon
    private By cartIcon = By.className("shopping_cart_link");

    // Actions
    public void addFirstProductToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    public void clickCart() {
        driver.findElement(cartIcon).click();
    }
}
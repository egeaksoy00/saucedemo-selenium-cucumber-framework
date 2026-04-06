package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();
    
    LoginPage loginPage = new LoginPage(driver);

	ProductsPage productsPage = new ProductsPage(driver);
	CartPage cartPage = new CartPage(driver);
	String expectedProductName;
    
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com");
    }

    //Senaryo 1
    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("user should be redirected to the products page")
    public void user_should_be_redirected_to_the_products_page() {
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
    
    //Senaryo 2 
    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.login("wrong_user", "wrong_pass");
    }

    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        String error = loginPage.getErrorMessage();
        assertTrue(error.contains("Epic sadface"));
    }
    
    //Senaryo 3
    @When("user adds a product to the cart")
    public void user_adds_a_product_to_the_cart() {
        expectedProductName = productsPage.getFirstProductName();
        productsPage.addFirstProductToCart();
        productsPage.clickCart();
    }

    @Then("user should see the product in the cart")
    public void user_should_see_the_product_in_the_cart() {
        String actualProductName = cartPage.getCartItemName();
        assertEquals(expectedProductName, actualProductName);
    }
}
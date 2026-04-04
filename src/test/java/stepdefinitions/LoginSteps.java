package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com");
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("user should be redirected to the products page")
    public void user_should_be_redirected_to_the_products_page() {
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
    
    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.login("wrong_user", "wrong_pass");
    }

    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        String error = loginPage.getErrorMessage();
        assertTrue(error.contains("Epic sadface"));
    }
}
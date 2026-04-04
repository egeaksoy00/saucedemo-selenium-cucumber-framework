package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com");
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should be redirected to the products page")
    public void user_should_be_redirected_to_the_products_page() {
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
}
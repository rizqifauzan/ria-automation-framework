package web.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import web.pages.*;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;

    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("User should be redirected to products page")
    public void user_should_be_redirected_to_products_page() {
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @When("User adds {string} to cart")
    public void user_adds_item_to_cart(String productName) {
        homePage.addItemToCart(productName);
    }

    @When("User navigates to cart")
    public void user_navigates_to_cart() {
        homePage.goToCart(); // ✅ method yang benar
    }

    @Then("Item {string} should be in the cart")
    public void item_should_be_in_cart(String productName) {
        Assert.assertTrue("Item not found in cart", cartPage.isItemInCart(productName));
    }

    @When("User logs out")
    public void user_logs_out() {
        homePage.logout();
    }

    @Then("User should be redirected to login page")
    public void user_should_be_redirected_to_login_page() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
    }

    @Given("User is logged in")
    public void user_is_logged_in() {
        user_is_on_the_login_page();
        user_logs_in_with_username_and_password("standard_user", "secret_sauce");
        user_should_be_redirected_to_products_page();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

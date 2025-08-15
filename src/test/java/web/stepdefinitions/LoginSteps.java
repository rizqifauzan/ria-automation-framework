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
    public void userIsOnTheLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);

        System.out.println("Opened login page.");
    }

    @When("User logs in with username {string} and password {string}")
    public void userLogsInWithUsernameAndPassword(String username, String password) {
        System.out.println("Logging in with username: " + username);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("User should be redirected to products page")
    public void userShouldBeRedirectedToProductsPage() {
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        System.out.println("Successfully logged in, now on products page.");
    }

    @Then("User should see error message {string}")
    public void userShouldSeeErrorMessage(String expectedMessage) {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
        Assert.assertTrue(error.getText().contains(expectedMessage));
        System.out.println("Error message verified: " + error.getText());
    }

    @When("User adds {string} to cart")
    public void userAddsToCart(String productName) {
        System.out.println("Adding product to cart: " + productName);
        homePage.addItemToCart(productName);
    }

    @When("User navigates to cart")
    public void userNavigatesToCart() {
        System.out.println("Navigating to cart page...");
        homePage.goToCart();
    }

    @Then("Item {string} should be in the cart")
    public void itemShouldBeInTheCart(String productName) {
        System.out.println("Verifying item in cart: " + productName);
        Assert.assertTrue("Item not found in cart", cartPage.isItemInCart(productName));
    }

    @When("User logs out")
    public void userLogsOut() {
        System.out.println("Attempting to logout...");
        homePage.logout();
    }

    @Then("User should be redirected to login page")
    public void userShouldBeRedirectedToLoginPage() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
        Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
        System.out.println("Successfully logged out and redirected to login page.");
    }

    @Given("User is logged in")
    public void userIsLoggedIn() {
        userIsOnTheLoginPage();
        userLogsInWithUsernameAndPassword("standard_user", "secret_sauce");
        userShouldBeRedirectedToProductsPage();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing browser...");
            driver.quit();
        }
    }
}

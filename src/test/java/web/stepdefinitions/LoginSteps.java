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
    ProductPage productPage;
    CartPage cartPage;

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        System.setProperty("webdriver.chrome.driver", "/Users/mac/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Inisialisasi Page Object
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        // Buka modal login
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
    }

    @When("User logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
    }

    @Then("User should see welcome message")
    public void user_should_see_welcome_message() {
        try {
            WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
            String welcomeText = welcome.getText();
            Assert.assertTrue("Welcome message not found!", welcomeText.contains("Welcome"));
        } catch (Exception e) {
            Assert.fail("Welcome message not displayed");
        }
    }

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String expectedMessage) {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String actualMessage = alert.getText();
            Assert.assertEquals(expectedMessage, actualMessage);
            alert.accept();
        } catch (NoAlertPresentException | TimeoutException e) {
            Assert.fail("Expected alert with message: " + expectedMessage);
        }
    }

    @When("User clicks logout")
    public void user_clicks_logout() {
        try {
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
            logoutButton.click();
        } catch (Exception e) {
            Assert.fail("Logout failed: " + e.getMessage());
        }
    }

    @Then("User should not see welcome message")
    public void user_should_not_see_welcome_message() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("nameofuser")));
        boolean isWelcomeDisplayed = driver.findElements(By.id("nameofuser")).size() > 0;
        Assert.assertFalse("User still logged in", isWelcomeDisplayed);
    }

    @When("User adds {string} to cart")
    public void user_adds_item_to_cart(String itemName) {
        homePage.selectCategory("Phones");
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(itemName)));
        homePage.selectProduct(itemName);
        productPage.clickAddToCart();
        productPage.navigateBackToHome();
    }

    @Then("Item {string} should be in the cart")
    public void item_should_be_in_cart(String itemName) {
        cartPage.openCart();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("table-responsive")));
        Assert.assertTrue(itemName + " not found in cart", cartPage.isItemInCart(itemName));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

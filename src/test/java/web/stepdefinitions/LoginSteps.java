package web.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import web.pages.LoginPage;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/riapuspita/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        loginPage = new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.openLoginModal();
        Thread.sleep(2000);
    }

    @When("User logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) throws InterruptedException {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        Thread.sleep(2000); // Tunggu hasil login
    }

    @Then("User should see welcome message")
    public void user_should_see_welcome_message() {
        String welcomeText = driver.findElement(By.id("nameofuser")).getText();
        assert welcomeText.contains("Welcome") : "User not logged in successfully.";
    }

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String expectedMessage) {
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        assert actualMessage.equals(expectedMessage) : "Expected: " + expectedMessage + " but got: " + actualMessage;
        alert.accept();
    }
}



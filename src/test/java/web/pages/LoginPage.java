package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By loginModalBtn = By.id("login2");
    By usernameField = By.id("loginusername");
    By passwordField = By.id("loginpassword");
    By loginButton = By.xpath("//button[text()='Log in']");

    // Method untuk membuka modal login
    public void openLoginModal() {
        driver.findElement(loginModalBtn).click();
    }

    // Method untuk mengisi username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Method untuk mengisi password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method untuk klik tombol login
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method kombinasi login langsung
    public void login(String username, String password) {
        openLoginModal();
        try {
            Thread.sleep(2000); // delay agar modal muncul
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}


package web.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void addItemToCart(String productName) {
        By addToCartButton = By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void goToCart() {
        By cartIcon = By.className("shopping_cart_link");
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();

        // Tunggu halaman cart terbuka (bukan item spesifik)
        wait.until(ExpectedConditions.urlContains("cart.html"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title"))); // "Your Cart" heading
    }

    public void logout() {
        By menuButton = By.id("react-burger-menu-btn");
        By logoutLink = By.id("logout_sidebar_link");

        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();

        // Tunggu menu sidebar muncul (ada tombol close menu)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-cross-btn")));

        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();

        // Tambahan: pastikan redirect selesai
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
    }
}

package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Klik tombol "Add to cart" untuk produk tertentu
    public void addItemToCart(String productName) {
        By addToCartButton = By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    // Navigasi ke halaman cart
    public void goToCart() {
        By cartIcon = By.className("shopping_cart_link");
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    // Logout dari menu samping
    public void logout() {
        By menuButton = By.id("react-burger-menu-btn");
        By logoutLink = By.id("logout_sidebar_link");

        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();

        // Tunggu hingga menu terbuka dan logout bisa diklik
        WebElement logoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
        wait.until(ExpectedConditions.elementToBeClickable(logoutElement)).click();
    }

    // Validasi apakah user sudah di halaman produk
    public boolean isOnProductPage() {
        return driver.getCurrentUrl().contains("inventory.html");
    }
}

package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locator untuk tombol "Add to cart"
    By addToCartButton = By.linkText("Add to cart");

    // Klik tombol Add to Cart dan tunggu alert muncul
    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    // Kembali ke halaman utama setelah menambahkan item
    public void navigateBackToHome() {
        driver.navigate().back();
    }

    // Validasi item yang ditampilkan adalah benar (opsional)
    public String getProductTitle() {
        WebElement titleElement = driver.findElement(By.cssSelector(".name"));
        return titleElement.getText();
    }
}

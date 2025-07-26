package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method dinamis untuk klik kategori berdasarkan nama
    public void selectCategory(String categoryName) {
        By categoryLink = By.linkText(categoryName);
        wait.until(ExpectedConditions.elementToBeClickable(categoryLink)).click();
    }

    // Method untuk klik produk berdasarkan nama
    public void selectProduct(String productName) {
        By productLink = By.linkText(productName);
        wait.until(ExpectedConditions.elementToBeClickable(productLink)).click();
    }
}

package web.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // ditambah jadi 15s
    }

    public boolean isItemInCart(String productName) {
        By itemLocator = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
            return driver.findElement(itemLocator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}

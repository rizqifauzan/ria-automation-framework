package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isItemInCart(String itemName) {
        By itemLocator = By.xpath("//div[@class='inventory_item_name' and text()='" + itemName + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
        return driver.findElements(itemLocator).size() > 0;
    }
}

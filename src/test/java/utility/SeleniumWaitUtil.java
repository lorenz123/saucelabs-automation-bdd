package utility;

import enums.WebElementType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaitUtil {

    public static final Integer WAITING_TIME = 40;

    public static final Integer POLLING_TIME = 1;
    public static WebElement getElementWithPolling(WebDriverWait wait, By webElementBy) {
        wait.pollingEvery(Duration.ofSeconds(POLLING_TIME));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(webElementBy));
        return element;
    }

    public static WebDriverWait getWebDriverWait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME));
        return wait;
    }
    public static By getBy(String path, WebElementType type) {
        switch (type){
            case ID:
                return By.id(path);
            case NAME:
                return By.name(path);
            case X_PATH:
                return By.xpath(path);
            case TAG_NAME:
                return By.tagName(path);
            case CSS_SELECTOR:
                return By.cssSelector(path);
            default:
                throw new IllegalArgumentException();
        }
    }
}

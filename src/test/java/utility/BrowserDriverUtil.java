 package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class BrowserDriverUtil {
    public WebDriver driver;
    public WebDriverWait explicitWait;
    public final int TIMEOUT = 10;
    public final int Page_Load_Timeout = 20;

    public WebDriver getChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Page_Load_Timeout));
        return driver;
    }

    public void openPage(String url)
    {
        driver.get(url);
    }

    public String getCurrentPageUrl()
    {
        return driver.getCurrentUrl();
    }

    public void quitDriver()
    {
        driver.quit();
    }
}

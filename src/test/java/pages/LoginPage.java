package pages;

import enums.WebElementType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utility.SeleniumWaitUtil.*;

public class LoginPage {
    //constants
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //locators/paths
    private final String LOGIN_URL = "https://www.saucedemo.com/";
    private final String USERNAME_ID = "user-name";
    private final String PASSWORD_ID = "password";
    private final String LOGIN_ID = "login-button";
    private final String LOGIN_ERROR_XPATH = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";

    public WebElement getUsernameField() {
        return getElementWithPolling(wait, getBy(USERNAME_ID, WebElementType.ID));
    }

    public WebElement getPasswordField() {
        return getElementWithPolling(wait, getBy(PASSWORD_ID, WebElementType.ID));
    }

    public WebElement getLoginButton() {
        return getElementWithPolling(wait, getBy(LOGIN_ID, WebElementType.ID));
    }

    public void navigateToLoginPage(){
        driver.get(LOGIN_URL);
    }

    public WebElement getLoginErrorMessage() {
        return getElementWithPolling(wait, getBy(LOGIN_ERROR_XPATH, WebElementType.X_PATH));
    }
}

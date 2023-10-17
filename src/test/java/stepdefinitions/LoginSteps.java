package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utility.BrowserDriverUtil;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static utility.SeleniumWaitUtil.getWebDriverWait;

public class LoginSteps {

    BrowserDriverUtil manager = new BrowserDriverUtil();
    WebDriver driver = manager.getChromeDriver();
    WebDriverWait wait = getWebDriverWait(driver);
    LoginPage loginPage = new LoginPage(driver, wait);

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("User enters valid username and valid password")
    public void userEntersValidUsernameAndValidPassword() {
        loginPage.getUsernameField().sendKeys("standard_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
    }

    @And("clicks the login button")
    public void clicksTheLoginButton() {
        loginPage.getLoginButton().click();
    }

    @Then("User should be redirected to the Home or Products page")
    public void userShouldBeRedirectedToTheHomeOrProductsPage() {
        String currentPageUrl = manager.getCurrentPageUrl();
        assertEquals(currentPageUrl, "https://www.saucedemo.com/inventory.html");
        manager.quitDriver();
    }

    @When("User enters invalid credentials")
    public void userEntersInvalidCredentials() {
        loginPage.getUsernameField().sendKeys("test");
        loginPage.getPasswordField().sendKeys("test");
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        WebElement loginErrorMessage = loginPage.getLoginErrorMessage();
        String loginErrorMessageText = loginPage.getLoginErrorMessage().getText();
        String actualLoginError = "Epic sadface: Username and password do not match any user in this service";

        assertTrue(loginErrorMessage.isDisplayed());
        assertEquals(loginErrorMessageText, actualLoginError);
        manager.quitDriver();
    }
}

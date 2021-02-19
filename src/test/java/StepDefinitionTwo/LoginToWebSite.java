package StepDefinitionTwo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Base;
import utilities.Driver;
import utilities.Selectors;

public class LoginToWebSite extends Base {

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Given("I navigate to Mersys WebSite {string}")
    public void iNavigateToMersysWebSite(String arg0) {
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.get(arg0);
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        driver.findElement(Selectors.loginButtonMersys).click();
    }

    @Then("I successfully login in Mersys Website")
    public void iLoginInMersysWebsite() {
        WebElement cookieButton = driver.findElement(By.cssSelector("a[aria-label='dismiss cookie message']"));
        cookieButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.menu));
    }

    @When("I login with valid password {string} and login {string}")
    public void iLoginWithValidPasswordAndLogin(String arg0, String arg1) {
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.usernameMersys));
        driver.findElement(Selectors.usernameMersys).sendKeys(arg0);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.passwordMersys));
        driver.findElement(Selectors.passwordMersys).sendKeys(arg1);
    }

    @When("I try to login with invalid login {string} or password {string}")
    public void iTryToLoginWithInvalidLoginOrPassword(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.usernameMersys));
        driver.findElement(Selectors.usernameMersys).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.passwordMersys));
        driver.findElement(Selectors.passwordMersys).sendKeys(password);
    }

    @Then("I got an error message {string}")
    public void iGotAnErrorMessage(String errorMessage) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.alert, errorMessage));
        String alertText = driver.findElement(Selectors.alert).getText();
        System.out.println(alertText);
        Assert.assertEquals(errorMessage, alertText);
    }
}

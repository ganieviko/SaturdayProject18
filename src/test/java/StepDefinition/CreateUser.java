package StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Base;
import utilities.Driver;
import utilities.Selectors;

import java.util.Map;

public class CreateUser extends Base {

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @When("I create username with {string} length less four characters and password {string} with  length less four characters")
    public void iCreateUsernameWithUsernameLengthLessFourCharactersAndPasswordPasswordLengthIsFourOrMore(String username, String password) {

        wait.until(ExpectedConditions.elementToBeClickable(Selectors.username));
        driver.findElement(Selectors.username).sendKeys(username);

        wait.until(ExpectedConditions.elementToBeClickable(Selectors.password));
        driver.findElement(Selectors.password).sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(Selectors.saveButton));
        driver.findElement(Selectors.saveButton).click();
    }

    @Then("I got an alert UserName message {string} or {string}")
    public void iGotAnAlertMessage(String messageUserName, String messagePassword) {
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println("Username or Password alert message " + alertText);
        if (alertText.equals(messageUserName)) {
            Assert.assertEquals(alertText, messageUserName);
        } else if (alertText.equals(messagePassword)) {
            Assert.assertEquals(alertText, messagePassword);
        }
    }

    @When("I create username with user name and password whose lengths are more then tree characters using following parameters")
    public void iCreateUsernameWithUserNameAndPasswordWhoseLengthsAreMoreThenCharacters(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);

        wait.until(ExpectedConditions.elementToBeClickable(Selectors.username));
        driver.findElement(Selectors.username).sendKeys(map.get("username"));

        wait.until(ExpectedConditions.elementToBeClickable(Selectors.password));
        driver.findElement(Selectors.password).sendKeys(map.get("password"));

        wait.until(ExpectedConditions.elementToBeClickable(Selectors.saveButton));
        driver.findElement(Selectors.saveButton).click();

    }

    @Then("I see my my username and password on screen")
    public void iSeeMyMyUsernameAndPasswordOnScreen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.userNameInput));
        String userNameInput = driver.findElement(Selectors.userNameInput).getText();
        System.out.println(userNameInput);
            boolean containLogin = false;
        if (userNameInput.contains("Artur Ganiev")){
           containLogin = true;
        }
        System.out.println(containLogin);
    }

    @When("I create login using following parameters and save it")
    public void iTryLoginUsingPreviousLoginAndPasswordThatWeJustCreated(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.username));
        driver.findElement(Selectors.username).sendKeys(map.get("username"));
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.password));
        driver.findElement(Selectors.password).sendKeys(map.get("password"));
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.saveButton));
        driver.findElement(Selectors.saveButton).click();

    }

    @And("go to login page and try login with parameters I just create")
    public void goToLoginPageAndTryLoginWithParametersIJustCreate(DataTable table){
        Map<String, String> map = table.asMap(String.class, String.class);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.goToLoginPage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.username));
        driver.findElement(Selectors.username).sendKeys(map.get("username"));
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.password));
        driver.findElement(Selectors.password).sendKeys(map.get("password"));
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.testLoginButton)).click();
    }

    @Then("I see success message {string}")
    public void iSeeSuccessMessage(String message) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.alertMessage, "**Successful Login**"));
        String successfulMessage = driver.findElement(Selectors.alertMessage).getText();
        System.out.println(successfulMessage);
        Assert.assertEquals(successfulMessage, message);

    }

    @And("go to login page and try login with different parameters such as {string} {string}")
    public void goToLoginPageAndTryLoginWithDifferentParametersSuchAs(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.goToLoginPage)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.username));
        driver.findElement(Selectors.username).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.password));
        driver.findElement(Selectors.password).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.testLoginButton)).click();
    }

    @Then("I see message {string}")
    public void iSeeMessage(String failedMessage) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.alertMessage, "**Failed Login**"));
        String successfulMessage = driver.findElement(Selectors.alertMessage).getText();
        System.out.println(successfulMessage);
        Assert.assertEquals(successfulMessage, failedMessage);
    }

    @When("I try to login with a invalid {string} and {string}")
    public void iTryToLoginWithAValidAndAShort(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.username));
        driver.findElement(Selectors.username).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.password));
        driver.findElement(Selectors.password).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.testLoginButton)).click();
    }

    @And("go to the login page")
    public void goToLoginPageAndTryLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.goToLoginPage)).click();
    }

    @Then("I verify the alert {string} {string}")
    public void iVerifyTheAlert(String ErrorMessage, String type) {
           switch (type){
               case "message" : wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.alertMessage, ErrorMessage));
                   String popUpMessage = driver.findElement(Selectors.alertMessage).getText();
                   System.out.println(popUpMessage);
                   Assert.assertEquals(popUpMessage, ErrorMessage);
                   break;

               case "popUp" : String alertText = driver.switchTo().alert().getText();
                   driver.switchTo().alert().accept();
                   System.out.println("Username or Password alert message " + alertText);
                   Assert.assertEquals(alertText, ErrorMessage);
               break;
           }
    }

}





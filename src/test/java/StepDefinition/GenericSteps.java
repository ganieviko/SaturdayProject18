package StepDefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Base;
import utilities.Driver;
import utilities.Selectors;


public class GenericSteps extends Base {
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

    @Given("I navigate to website {string}")
    public void iNavigateToWebsite(String url) {

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.get(url);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.addUser));
        driver.findElement(Selectors.addUser).click();
    }
}

package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import utilities.Driver;

@CucumberOptions(
        features = {"src/test/java/partTwo.feature"},
        glue = {"StepDefinitionTwo"},
        plugin = {"pretty", "html:target/report/reportMersys/index.html"}
)
public class TestParallelRunnerMersys extends AbstractTestNGCucumberTests {
    WebDriver driver = Driver.getDriver();
    @AfterClass
    public void setUpDriver() {
       driver.quit();
    }
}

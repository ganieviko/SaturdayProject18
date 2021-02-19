package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import utilities.Driver;

@CucumberOptions(
        features = {"src/test/java/partOne.feature"},
        glue = {"StepDefinition"},
        plugin = {"pretty", "html:target/report/index.html"}
)
public class TestParallelRunner extends AbstractTestNGCucumberTests {
    WebDriver driver = Driver.getDriver();
    @AfterClass
    public void setUpDriver() {
       driver.quit();
    }

}

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
//    <?xml version="1.0" encoding="UTF-8"?>
//<project xmlns="http://maven.apache.org/POM/4.0.0"
//        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
package testRunner;

import io.cucumber.testng.CucumberOptions;
import testBase.TestBase;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinition"},
        plugin = {"pretty", "html:target/cucumber/report.html"},
        tags = "@feature"
)
public class TestRunner extends TestBase {
}

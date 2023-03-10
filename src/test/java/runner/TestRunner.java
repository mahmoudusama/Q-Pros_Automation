package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/features",
        glue = {"stepDefinition"},
        plugin = {"pretty","html:OutputReport/cucumber-pretty"})
public class TestRunner extends TestBase{
}

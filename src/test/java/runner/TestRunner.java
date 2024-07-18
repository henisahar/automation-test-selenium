package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"StepDefinition", "utility"},
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"}
)
public class TestRunner {
}

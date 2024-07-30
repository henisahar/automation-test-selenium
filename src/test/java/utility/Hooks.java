package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Hooks {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.get().log(Status.FAIL, "Scenario failed: " + scenario.getName());
            // Optionally add screenshot capture logic here
        } else {
            test.get().log(Status.PASS, "Scenario passed: " + scenario.getName());
        }
        extent.flush();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        Hooks.getTest().log(Status.INFO, "Executing step: " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            Hooks.getTest().log(Status.FAIL, "Step failed: " + scenario.getName());
            // Optionally add screenshot capture logic here
        } else {
            Hooks.getTest().log(Status.PASS, "Step passed: " + scenario.getName());
        }
    }

    public static ExtentTest getTest() {
        return test.get();
    }
}

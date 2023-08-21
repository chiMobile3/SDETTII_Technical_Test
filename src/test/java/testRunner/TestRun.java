package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //features = "src/test/java/features/Scenarios.feature",
        features = "src/test/java/features/GuestScenario.feature",
        glue = "Hooks"
//        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//                "timeline:test-output-thread/", "rerun:target/failedrerun.txt"}
)
public class TestRun extends AbstractTestNGCucumberTests {
}

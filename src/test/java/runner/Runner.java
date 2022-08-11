package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/login.feature", glue={"tests.steps"},
        monochrome = true,
        plugin={"pretty", "junit:target/JUnitReports/report.xml"},
        tags="@TestLoginWithNoExternalData")
class Runner {
}

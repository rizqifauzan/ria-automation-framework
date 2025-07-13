package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/api",
        glue = "api.stepdefinitions",
        plugin = {
                "pretty",
                "json:build/reports/api-test-report.json",
                "html:build/reports/api-test-report.html"
        },
        tags = "@api",
        monochrome = true
)
public class ApiTestRunner {
}



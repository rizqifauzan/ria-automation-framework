package web.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:web.features", // folder .feature untuk Web UI
        glue = "web.stepdefinitions",                 // lokasi step definitions Web UI
        plugin = {
                "pretty",
                "json:build/reports/cucumber/web-report.json",
                "html:build/reports/cucumber/web-report.html"
        },
        tags = "@web"
)
public class WebTestRunner {
}

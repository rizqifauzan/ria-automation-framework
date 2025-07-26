package web.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/web_features",  // atau sesuai folder feature kamu
        glue = "web.stepdefinitions",
        tags = "@web",
        plugin = {"pretty", "html:target/web-report.html"}
)
public class WebTestRunner {}

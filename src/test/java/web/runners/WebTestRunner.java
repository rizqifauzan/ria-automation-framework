package web.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/web_features",
        glue = {"web.stepdefinitions"},
        plugin = {
                "pretty",
                "html:build/reports/tests/web-cucumber.html",   // ✅ HARUS ADA
                "json:build/reports/tests/web-cucumber.json"    // ✅ Opsional tapi disarankan
        },
        monochrome = true
)
public class WebTestRunner {}

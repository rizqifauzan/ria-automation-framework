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
                "html:build/reports/tests/testWeb/web-cucumber.html",   // ✅ HARUS ADA
                "json:build/reports/tests/testWeb/web-cucumber.json"    // ✅ Opsional tapi disarankan
        },
        tags = "@web",
        monochrome = true
)
public class WebTestRunner {}

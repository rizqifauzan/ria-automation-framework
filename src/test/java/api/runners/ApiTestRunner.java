package api.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/api_features",         // Lokasi file .feature
        glue = {"api.stepdefinitions"},                      // Lokasi step definition (package)
        plugin = {
                "pretty",
                "html:build/reports/tests/testApi/api-cucumber.html",
                "json:build/reports/tests/testApi/api-cucumber.json"
        },
        tags = "@api",                                        // Hanya jalankan skenario bertag @api
        monochrome = true                                     // Output lebih bersih di console
)
public class ApiTestRunner {}


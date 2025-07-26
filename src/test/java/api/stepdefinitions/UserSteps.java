package api.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import api.context.ApiContext;

public class UserSteps {

    private static final String BASE_URL = "https://reqres.in/api";
    private Response response;
    private RequestSpecification request;

    @Given("ReqRes API is available")
    public void apiIsAvailable() {
        baseURI = "https://reqres.in/api";
        request = given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1"); // ← Tambahkan header API key di sini
    }

    @When("I send a GET request to {string}")
    public void getRequest(String endpoint) {
        response = request.when().get(endpoint);
        response.then().log().all();
    }

    @When("I send a POST request to {string} with body:")
    public void postRequest(String endpoint, String body) {
        response = request.body(body).when().post(endpoint);
        response.then().log().all();

        if (response.getStatusCode() == 201) {
            String id = response.jsonPath().getString("id");
            ApiContext.createdUserId = id;
        }
    }

    @When("I send a PUT request to created user with body:")
    public void putRequestToCreatedUser(String body) {
        Assert.assertNotNull("Created user ID must not be null", ApiContext.createdUserId);
        String endpoint = "/users/" + ApiContext.createdUserId;
        response = request.body(body).when().put(endpoint);
        response.then().log().all();
    }

    @When("I send a DELETE request to created user")
    public void deleteRequestToCreatedUser() {
        Assert.assertNotNull("Created user ID must not be null", ApiContext.createdUserId);
        String endpoint = "/users/" + ApiContext.createdUserId;
        response = request.when().delete(endpoint);
        response.then().log().all();
    }

    @Then("The response status code should be {int}")
    public void responseStatusShouldBe(int code) {
        response.then().statusCode(code);
    }

    @Then("The response should contain {string}")
    public void responseShouldContain(String key) {
        response.then().body("$", hasKey(key));
    }

    @Then("The value of {string} should be {string}")
    public void valueOfKeyShouldBe(String key, String expectedValue) {
        String actual = response.jsonPath().getString(key);
        Assert.assertEquals(expectedValue, actual);
    }
}

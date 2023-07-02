package testing;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;


public class StepDefinition {

    private String baseURL;
    private Response response;

    @Given("I have the base URL {string}")
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
        RestAssured.baseURI = baseURL;
    }

    @When("I send a POST request to {string} with the following request body:")
    public void sendPostRequest(String endpoint, String requestBody) {
        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        response.then()
                .statusCode(expectedStatusCode);
    }

    @Then("the response body should contain a valid token")
    public void verifyToken() {
        response.then()
                .body("token", Matchers.notNullValue());
    }
}


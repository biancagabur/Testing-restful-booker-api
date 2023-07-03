package tokenGenerationTests;

import helper.FileHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class StepDefinition {
    private Response response;
    private final FileHelper fileHelperValid = new FileHelper("src/test/resources/requests/validTokenGenerationRequest.json");
    private final FileHelper fileHelperInvalid = new FileHelper("src/test/resources/requests/invalidTokenGenerationRequest.json");

    @Given("I have the base URL {string}")
    public void setBaseURL(String baseURL) {
        RestAssured.baseURI = baseURL;
    }

    @When("I send a POST request to {string} with a valid request body")
    public void iSendAPOSTRequestToWithAValidRequestBody(String endpoint) throws IOException {
        String requestBody = fileHelperValid.readFromFile(fileHelperValid.getFilePath());
        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(endpoint);
    }
    @When("I send a POST request to {string} with the an invalid request body:")
    public void iSendAPOSTRequestToWithTheAnInvalidRequestBody(String endpoint) throws IOException {
        String requestBody = fileHelperInvalid.readFromFile(fileHelperInvalid.getFilePath());
        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    @And("I set the request body from file {string}")
    public void iSetTheRequestBodyFromFile(String filePath) throws IOException {
        String requestBody = new String(Files.readAllBytes(Paths.get(filePath)));
        response = given().body(requestBody).when().post();
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

    @And("the response body should contain a reason field with the text {string}")
    public void theResponseBodyShouldContainAReasonFieldWithTheText(String expectedReason) {
        System.out.println(response.then().log().body());
        response.then().body("reason",Matchers.equalTo(expectedReason));
    }



}


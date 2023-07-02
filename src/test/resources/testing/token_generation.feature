Feature: Token Generation

  Scenario: Create a token
    Given I have the base URL "https://restful-booker.herokuapp.com"
    When I send a POST request to "/auth" with the following request body:
      """
      {
        "username": "admin",
        "password": "password123"
      }
      """
    Then the response status code should be 200
    And the response body should contain a valid token

Feature: Token Generation

  Scenario: Create a token - valid username and password
    Given I have the base URL "https://restful-booker.herokuapp.com"
    When I send a POST request to "/auth" with a valid request body
    Then the response status code should be 200
    And the response body should contain a valid token

  Scenario: Create token - Wrong username and password
    Given I have the base URL "https://restful-booker.herokuapp.com"
    When I send a POST request to "/auth" with the an invalid request body:
    Then the response status code should be 200
    And the response body should contain a reason field with the text "Bad credentials"
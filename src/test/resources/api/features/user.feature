Feature: API Testing - User Management

  Background:
    Given User API is available

  @api @getUser
  Scenario: Get user by ID
    When I send a GET request to "/user/63a804408eb0cb069b57e43a"
    Then The response status code should be 200
    And The response should contain "firstName"

  @api @createUser
  Scenario: Create a new user
    When I send a POST request to "/user/create" with body:
      """
      {
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com"
      }
      """
    Then The response status code should be 200
    And The response should contain "id"

  @api @updateUser
  Scenario: Update an existing user
    When I send a PUT request to created user with body:
    """
    {
      "firstName": "Jane"
    }
    """
    Then The response status code should be 200
    And The response should contain "firstName"
    And The value of "firstName" should be "Jane"

  @api @deleteUser
  Scenario: Delete a user
    When I send a DELETE request to created user
    Then The response status code should be 204


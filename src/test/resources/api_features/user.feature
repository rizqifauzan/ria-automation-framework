Feature: API Testing - User Management with ReqRes

  Background:
    Given ReqRes API is available

  @api @getUser
  Scenario: Get user by ID
    When I send a GET request to "/users/2"
    Then The response status code should be 200
    And The response should contain "data"

  @api @createUser
  Scenario: Create a new user
    When I send a POST request to "/users" with body:
      """
      {
        "name": "Friedrich-Karl",
        "job": "Soldier"
      }
      """
    Then The response status code should be 201
    And The response should contain "id"

  @api @updateUser
  Scenario: Update an existing user
    When I send a PUT request to created user with body:
      """
      {
        "name": "Karl-Heinz",
        "job": "General"
      }
      """
    Then The response status code should be 200
    And The value of "name" should be "Karl-Heinz"

  @api @deleteUser
  Scenario: Delete a user
    When I send a DELETE request to created user
    Then The response status code should be 204

  @api @notFound
  Scenario: Get non-existing user
    When I send a GET request to "/users/23"
    Then The response status code should be 404

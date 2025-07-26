Feature: User Login on Demoblaze

  @web
  Scenario: Successful login with valid credentials
    Given User navigates to login page
    When User logs in with "air2025" and "12345**"
    Then User should see welcome message

  Scenario: Failed login with wrong password
    Given User navigates to login page
    When User logs in with "air2025" and "wrongpass"
    Then User should see error message "Wrong password."

  Scenario: Failed login with non-existing user
    Given User navigates to login page
    When User logs in with "usernotexist" and "abc123"
    Then User should see error message "Wrong password."

  Scenario: Successful logout after login
    Given User navigates to login page
    When User logs in with "ria2025" and "12345**"
    Then User should see welcome message
    When User clicks logout
    Then User should not see welcome message

  Scenario: Add item to cart after login
    Given User navigates to login page
    When User logs in with "ria2025" and "12345**"
    Then User should see welcome message
    When User adds "Samsung galaxy s6" to cart
    Then Item "Samsung galaxy s6" should be in the cart
    When User clicks logout
    Then User should not see welcome message

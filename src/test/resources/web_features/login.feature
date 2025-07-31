Feature: User Login and Cart Operations on Saucedemo

  @web
  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User logs in with username "standard_user" and password "secret_sauce"
    Then User should be redirected to products page

  @web
  Scenario: Failed login with invalid credentials
    Given User is on the login page
    When User logs in with username "locked_out_user" and password "secret_sauce"
    Then User should be redirected to login page

  @web
  Scenario: Logout from product page
    Given User is logged in
    When User logs out
    Then User should be redirected to login page

  @web
  Scenario: Add item to cart and verify
    Given User is logged in
    When User adds "Sauce Labs Backpack" to cart
    And User navigates to cart
    Then Item "Sauce Labs Backpack" should be in the cart

  @web @e2e
  Scenario: End-to-end test – login, add to cart, logout
    Given User is logged in
    When User adds "Sauce Labs Bike Light" to cart
    And User navigates to cart
    Then Item "Sauce Labs Bike Light" should be in the cart
    When User logs out
    Then User should be redirected to login page

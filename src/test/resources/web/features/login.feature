Feature: User Login

  Scenario: Login dengan kredensial yang valid
    Given User navigates to login page
    When User logs in with "validUser" and "validPass"
    Then User should see welcome message

  Scenario: Login dengan password yang salah
    Given User navigates to login page
    When User logs in with "validUser" and "wrongPass"
    Then User should see error message "Wrong password."

  Scenario: Login dengan username yang tidak ada
    Given User navigates to login page
    When User logs in with "unknownUser" and "somePass"
    Then User should see error message "User does not exist."

  Scenario: Login dengan field kosong
    Given User navigates to login page
    When User logs in with "" and ""
    Then User should see error message "Please fill out Username and Password."

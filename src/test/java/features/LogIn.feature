Feature: login user

  Scenario: validate user is able to log in after clicking on login button
    Given Navigate the user to the login page
    When The user successfully entered the login details
    Then The user should be able to view the profile page

  Scenario: Unsuccessful Login with empty fields
    Given Navigate the user to the login page
    When The user let the inputs empty
    Then The user should be able to view Login Error Message


  Scenario: Unsuccessful Login with Invalid email / Password
    Given Navigate the user to the login page
    When user enter wrong credentials
    Then user should be able to see error message

  Scenario: validate new user is able to view after clicking on new registration button
    Given Navigate the user to the login page
    When user clicks on new Registration button
    Then user should be able to see the registration page


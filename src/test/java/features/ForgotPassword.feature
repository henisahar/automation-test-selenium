Feature: Forgot Password
Scenario: validate new user is able to change his password if he forgot it
Given Navigate the user to the login page
When user clicks on forgot password
Then user should be able to see the change password page


  Scenario: Unsuccessful password change  with empty fields
    Given Navigate the user to the login page
    When user navigate to forgot password page and let the fields empty
    Then user should be able to see error empty fields

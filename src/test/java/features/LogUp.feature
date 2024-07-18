Feature: logup user
  Scenario: Unsuccessful Logup  with empty fields
    Given Navigate the user to the logup page
    When The user let the inputs  of the logup page empty
    Then The user should be able to view empty filds logup error

  Scenario: validate new user is able to view the login after clicking on return button
    Given Navigate the user to the logup page
    When user clicks on return button
    Then user should be able tp see the login page